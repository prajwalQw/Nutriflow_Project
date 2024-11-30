package com.example.nutriflow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddFoodActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CircleImageView toolbarUserImage;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference diaryDatabaseReference, foodDatabaseReference, userDatabaseReference;

    private TextView foodName, servingSize, numberOfServings, calories, carbs, fat, protein, createdBy;
    private Button addbtn;
    private LinearLayout numberOfServingsContainer;

    private String foodNameValue, servingSizeValue, numberOfSizeValue = "1", servingSizeUnitValue, caloriesValue, carbsValue, fatValue, proteinValue,
            foodCreator, createdByValue;

    private String intentFrom, intentFoodID;

    private String currentUserID;

    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        // Initialize toolbar
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add Food");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbarUserImage = findViewById(R.id.toolbar_user_image);
        toolbarUserImage.setVisibility(View.GONE);

        // Firebase initialization
        firebaseAuth = FirebaseAuth.getInstance();
        currentUserID = firebaseAuth.getCurrentUser().getUid();
        diaryDatabaseReference = FirebaseDatabase.getInstance("https://nutriflow-48394-default-rtdb.firebaseio.com").getReference().child("FoodDiaries");
        foodDatabaseReference = FirebaseDatabase.getInstance("https://nutriflow-48394-default-rtdb.firebaseio.com").getReference().child("Foods");
        userDatabaseReference = FirebaseDatabase.getInstance("https://nutriflow-48394-default-rtdb.firebaseio.com").getReference().child("Users");

        // Retrieve intent extras
        Intent intent = getIntent();
        intentFrom = intent.getStringExtra("intentFrom");
        intentFoodID = intent.getStringExtra("intentFoodID");

        // UI references
        foodName = findViewById(R.id.addfood_foodname);
        servingSize = findViewById(R.id.add_food_serving_size);
        numberOfServings = findViewById(R.id.add_food_number_of_serving);
        calories = findViewById(R.id.addfood_calories);
        carbs = findViewById(R.id.addfood_carbs);
        fat = findViewById(R.id.addfood_fat);
        protein = findViewById(R.id.addfood_protein);
        createdBy = findViewById(R.id.addfood_createdby);
        numberOfServingsContainer = findViewById(R.id.add_food_number_of_servings_container);

        addbtn = findViewById(R.id.addfood_addbutton);
        if (!TextUtils.isEmpty(intentFrom) && !intentFrom.equals("ProfileMenu")) {
            addbtn.setText(String.format("Add to %s", intentFrom));
        }

        loadingbar = new ProgressDialog(this);

        if (!TextUtils.isEmpty(intentFoodID)) {
            GetAndSetFoodDetails();
        }

        addbtn.setOnClickListener(v -> AddFoodToUserDiary());

        numberOfServingsContainer.setOnClickListener(v -> PopupServingSizeEditDialog());
    }

    private void PopupServingSizeEditDialog() {
        final Dialog numberOfServingEditDialog = new Dialog(this);
        numberOfServingEditDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        numberOfServingEditDialog.setContentView(R.layout.number_of_servings_edit_layout);
        numberOfServingEditDialog.setTitle("Number Of Serving Edit Window");
        numberOfServingEditDialog.show();
        if (numberOfServingEditDialog.getWindow() != null) {
            numberOfServingEditDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }

        final EditText numberOfServingsInput = numberOfServingEditDialog.findViewById(R.id.number_of_servings_dialog_input);
        final TextView errorMsg = numberOfServingEditDialog.findViewById(R.id.number_of_servings_dialog_error);
        errorMsg.setVisibility(View.GONE);

        Button cancelBtn = numberOfServingEditDialog.findViewById(R.id.number_of_servings_dialog_cancel_button);
        cancelBtn.setOnClickListener(v -> numberOfServingEditDialog.dismiss());

        Button submitBtn = numberOfServingEditDialog.findViewById(R.id.number_of_servings_dialog_submit_button);
        submitBtn.setOnClickListener(v -> {
            try {
                String input = numberOfServingsInput.getText().toString();
                if (TextUtils.isEmpty(input) || Double.parseDouble(input) <= 0) {
                    errorMsg.setVisibility(View.VISIBLE);
                } else {
                    numberOfSizeValue = input;
                    numberOfServingEditDialog.dismiss();
                    NewValueCalculation();
                }
            } catch (NumberFormatException e) {
                errorMsg.setVisibility(View.VISIBLE);
            }
        });
    }

    private void NewValueCalculation() {
        try {
            numberOfServings.setText(numberOfSizeValue);

            double multiplier = Double.parseDouble(numberOfSizeValue) / Double.parseDouble(servingSizeValue);

            calories.setText(String.format(Locale.US, "%.0f Calories", multiplier * Double.parseDouble(caloriesValue)));
            carbs.setText(String.format(Locale.US, "%.1fg", multiplier * Double.parseDouble(carbsValue)));
            fat.setText(String.format(Locale.US, "%.1fg", multiplier * Double.parseDouble(fatValue)));
            protein.setText(String.format(Locale.US, "%.1fg", multiplier * Double.parseDouble(proteinValue)));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error calculating new values.", Toast.LENGTH_SHORT).show();
        }
    }

    private void GetAndSetFoodDetails() {
        foodDatabaseReference.child(intentFoodID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    foodNameValue = dataSnapshot.child("foodname").getValue(String.class);
                    servingSizeValue = dataSnapshot.child("foodservingsize").getValue(String.class);
                    servingSizeUnitValue = dataSnapshot.child("foodservingsizeunit").getValue(String.class);
                    caloriesValue = dataSnapshot.child("foodcalories").getValue(String.class);
                    carbsValue = dataSnapshot.child("foodcarbs").getValue(String.class);
                    fatValue = dataSnapshot.child("foodfat").getValue(String.class);
                    proteinValue = dataSnapshot.child("foodprotein").getValue(String.class);
                    foodCreator = dataSnapshot.child("foodcreator").getValue(String.class);

                    foodName.setText(foodNameValue);
                    servingSize.setText(String.format("%s %s", servingSizeValue, servingSizeUnitValue));
                    calories.setText(String.format("%s Calories", caloriesValue));
                    carbs.setText(String.format("%sg", carbsValue));
                    fat.setText(String.format("%sg", fatValue));
                    protein.setText(String.format("%sg", proteinValue));

                    if (foodCreator != null) {
                        userDatabaseReference.child(foodCreator).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                createdByValue = snapshot.child("username").getValue(String.class);
                                createdBy.setText(createdByValue != null ? createdByValue : "NutriFlow Team");
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                    } else {
                        createdBy.setText("NutriFlow Team");
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void AddFoodToUserDiary() {
        if (!TextUtils.isEmpty(intentFrom) && !intentFrom.equals("ProfileMenu")) {
            loadingbar.setMessage(new SpannableString("Adding Food..."));
            loadingbar.show();

            HashMap<String, String> diaryMap = new HashMap<>();
            diaryMap.put("foodType", intentFrom.toLowerCase());
            diaryMap.put("numberOfServing", numberOfSizeValue);

            String currentDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.US).format(Calendar.getInstance().getTime());

            diaryDatabase
