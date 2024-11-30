package com.example.nutriflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nutriflow.adapter.MyDietPlanFoodAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyDietPlanActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CircleImageView toolbarUserImage;

    String height, weight, gender;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference foodDiaryDatabaseReference, foodDatabaseReference, userDatabaseReference, waterDiaryDatabaseReference,
            workoutDiaryDatabaseReference;

    private TextView waterGlasses;
    private LinearLayout warerGlassesContainer;

    private String currentUserID;

    private long diariesFoodCount, diariesWorkoutCount;

    private String intentFrom, intentUserID;

    private String currentDate;
    List<String> breakfastList, lunchList, eveningSnackList, dinnerList, exercisesList = new ArrayList<String>();

    private TextView diary_water_glasses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_diet_plan);


        Intent intent = getIntent();
        intentFrom = intent.getExtras().getString("intentFrom");
        if (intentFrom.equals("ViewAnotherUserProfile")) {
            intentUserID = intent.getExtras().getString("intentUserID");
        }


        /* Adding tool bar & title to diary activity and hiding user image */
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Recommended Diet Plan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarUserImage = (CircleImageView) findViewById(R.id.toolbar_user_image);
        toolbarUserImage.setVisibility(View.GONE);
        diary_water_glasses = findViewById(R.id.diary_water_glasses);


        /* getting current date */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currenDate = new SimpleDateFormat("dd-MMM-yyyy");
        currentDate = currenDate.format(calendar.getTime());


        firebaseAuth = FirebaseAuth.getInstance();
        currentUserID = firebaseAuth.getCurrentUser().getUid();

        userDatabaseReference = FirebaseDatabase.getInstance("https://nutriflow-48394-default-rtdb.firebaseio.com").getReference().child("Users").child(currentUserID);

        getDietPlanFromServer();

    }

    public void getDietPlanFromServer() {

        userDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        if (snapshot.getKey().equals("breakfast")) {
                            breakfastList = (List<String>) snapshot.getValue();
                            System.out.println("Breakfast List: " + breakfastList);
                        } else if (snapshot.getKey().equals("lunch")) {
                            lunchList = (List<String>) snapshot.getValue();
                            System.out.println("Lunch List: " + lunchList);
                        } else if (snapshot.getKey().equals("eveningSnack")) {
                            eveningSnackList = (List<String>) snapshot.getValue();
                            System.out.println("Evening Snack List: " + eveningSnackList);
                        } else if (snapshot.getKey().equals("dinner")) {
                            dinnerList = (List<String>) snapshot.getValue();
                            System.out.println("Dinner List: " + dinnerList);
                        } else if (snapshot.getKey().equals("exercises")) {
                            exercisesList = (List<String>) snapshot.getValue();
                            System.out.println("Exercises List: " + exercisesList);
                        } else if (snapshot.getKey().equals("userheight")) {
                            height = (String) snapshot.getValue();
                            System.out.println("Height: " + height);
                        } else if (snapshot.getKey().equals("usercurrentweight")) {
                            weight = (String) snapshot.getValue();
                            System.out.println("Weight: " + weight);
                        } else if (snapshot.getKey().equals("usergender")) {
                            gender = (String) snapshot.getValue();
                            System.out.println("Gender: " + gender);
                        }
                    }
                }

                // Inside your Activity or Fragment
                RecyclerView recyclerView = findViewById(R.id.diary_breakfast_foodlist);
                recyclerView.setLayoutManager(new LinearLayoutManager(MyDietPlanActivity.this));
                MyDietPlanFoodAdapter adapter = new MyDietPlanFoodAdapter(breakfastList, MyDietPlanActivity.this);
                recyclerView.setAdapter(adapter);

                RecyclerView diary_lunch_foodlist = findViewById(R.id.diary_lunch_foodlist);
                diary_lunch_foodlist.setLayoutManager(new LinearLayoutManager(MyDietPlanActivity.this));
                diary_lunch_foodlist.setAdapter(new MyDietPlanFoodAdapter(lunchList, MyDietPlanActivity.this));


                RecyclerView diary_dinner_foodlist = findViewById(R.id.diary_dinner_foodlist);
                diary_dinner_foodlist.setLayoutManager(new LinearLayoutManager(MyDietPlanActivity.this));
                diary_dinner_foodlist.setAdapter(new MyDietPlanFoodAdapter(dinnerList, MyDietPlanActivity.this));


                RecyclerView diary_snack_foodlist = findViewById(R.id.diary_snack_foodlist);
                diary_snack_foodlist.setLayoutManager(new LinearLayoutManager(MyDietPlanActivity.this));
                diary_snack_foodlist.setAdapter(new MyDietPlanFoodAdapter(eveningSnackList, MyDietPlanActivity.this));

                RecyclerView diary_workout_list = findViewById(R.id.diary_workout_list);
                diary_workout_list.setLayoutManager(new LinearLayoutManager(MyDietPlanActivity.this));
                diary_workout_list.setAdapter(new MyDietPlanFoodAdapter(exercisesList, MyDietPlanActivity.this));

                diary_water_glasses.setText(calculateWaterIntakeWithHeightAndWeight(gender, weight, height) + "");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error here
                System.out.println("Error: " + databaseError.getMessage());
            }
        });

    }

    public double calculateWaterIntakeWithHeightAndWeight(String userGender, String userWeightString, String userHeightString) {
        Double waterIntake = 0.0;

        // Constants for the calculation
        double weightFactorMale = 0.035;
        double weightFactorFemale = 0.031;
        double heightFactorMale = 0.029;
        double heightFactorFemale = 0.026;

        // Parse weight and height from string format
        double userWeight = Double.parseDouble(userWeightString);
        double userHeight = Double.parseDouble(userHeightString);

        // Calculate water intake based on gender, weight, and height
        if (userGender.equalsIgnoreCase("male")) {
            waterIntake = userWeight * weightFactorMale + userHeight * heightFactorMale;
        } else if (userGender.equalsIgnoreCase("female")) {
            waterIntake = userWeight * weightFactorFemale + userHeight * heightFactorFemale;
        }

        return waterIntake.intValue();
    }


}