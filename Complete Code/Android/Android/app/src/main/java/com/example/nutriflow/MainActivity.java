package com.example.nutriflow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutriflow.detection.ApiInterface;
import com.example.nutriflow.detection.ApiResponse;
import com.example.nutriflow.detection.DisplayFoodNutritionsActivity;
import com.example.nutriflow.detection.FoodDetails;
import com.example.nutriflow.detection.FoodInformation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnButtonClickListener,GroceryCallback {
    private Toolbar mToolBar;
    private CircleImageView toolbarUserImage;
    private ImageButton toolBarProfileEditBtn;
    private ImageView toolbarLogo, toolbarLogoText;

    private BottomNavigationView bottomNavigationView;

    private String intentFrom, intentUserID;
    private String currentUserID;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference userDatabaseReference;
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_CAMERA_CAPTURE = 2;

    private TextView mustNeededTextView;
    private TextView neededTextView;
    private TextView leastNeededTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();


        /* getting intent string */
        Intent intent = getIntent();
        intentFrom = intent.getExtras().getString("intentFrom");


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_bar);

        toolbarLogo = findViewById(R.id.toolbar_logo);
        toolbarLogo.setVisibility(View.VISIBLE);
        toolbarLogoText = findViewById(R.id.toolbar_logo_text);
        toolbarLogoText.setVisibility(View.VISIBLE);
        toolbarUserImage = (CircleImageView) findViewById(R.id.toolbar_user_image);
        toolBarProfileEditBtn = (ImageButton) findViewById(R.id.toolbar_profile_edit_button);
        toolBarProfileEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSendToSetupPage();
            }
        });



        /* Adding tool bar & title to main activity*/
        mToolBar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("");


        if ((savedInstanceState == null) && (currentUser != null)) {
            if (intentFrom.equals("CreatePostActivity")) {
                /* user redirect to feed fragment */
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new FeedFragment());
                fragmentTransaction.commit();
            } else if (intentFrom.equals("ViewAnotherUserProfile")) {
                intentUserID = intent.getExtras().getString("intentUserID");
                currentUserID = firebaseAuth.getCurrentUser().getUid();

                /* user redirect to profile fragment */
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new ProfileFragment());
                fragmentTransaction.commit();

                toolbarUserImage.setVisibility(View.GONE);
                toolBarProfileEditBtn.setVisibility(View.GONE);

                if (!currentUserID.equals(intentUserID)) {
                    bottomNavigationView.setVisibility(View.GONE);
                    toolbarUserImage.setVisibility(View.GONE);
                    toolBarProfileEditBtn.setVisibility(View.GONE);
                    getSupportActionBar().setTitle("Profile");
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    toolbarLogo.setVisibility(View.GONE);
                    toolbarLogoText.setVisibility(View.GONE);
                }
            } else if (intentFrom.equals("ProfileFragment")) {
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new ProfileFragment());
                fragmentTransaction.commit();

                toolbarUserImage.setVisibility(View.GONE);
                toolBarProfileEditBtn.setVisibility(View.GONE);
            } else {
                /* user redirect to home fragment */
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new HomeFragment());
                fragmentTransaction.commit();

                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        }


        if (currentUser != null) {
            SetToolbarUserImage();
        }


        /* Bottom navigation button click actions */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.bottom_nav_home) {
                    bottomNavigationView.getMenu().getItem(0).setChecked(true);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_frame, new HomeFragment());
                    fragmentTransaction.commit();

                    toolbarUserImage.setVisibility(View.VISIBLE);
                    toolBarProfileEditBtn.setVisibility(View.GONE);
                }

                if (id == R.id.bottom_nav_feed) {
                    bottomNavigationView.getMenu().getItem(1).setChecked(true);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_frame, new FeedFragment());
                    fragmentTransaction.commit();

                    toolbarUserImage.setVisibility(View.VISIBLE);
                    toolBarProfileEditBtn.setVisibility(View.GONE);
                }


                if (id == R.id.bottom_nav_services) {
                    bottomNavigationView.getMenu().getItem(2).setChecked(true);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_frame, new ServicesFragment());
                    fragmentTransaction.commit();

                    toolbarUserImage.setVisibility(View.VISIBLE);
                    toolBarProfileEditBtn.setVisibility(View.GONE);
                }

                if (id == R.id.bottom_nav_profile) {
                    bottomNavigationView.getMenu().getItem(3).setChecked(true);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_frame, new ProfileFragment());
                    fragmentTransaction.commit();

                    toolbarUserImage.setVisibility(View.GONE);
                    toolBarProfileEditBtn.setVisibility(View.GONE);
                }

                return false;
            }
        });


        toolbarUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, new ProfileFragment());
                fragmentTransaction.commit();

                toolbarUserImage.setVisibility(View.GONE);
                toolBarProfileEditBtn.setVisibility(View.GONE);
            }
        });


        loadOneWeekFoodItems();


    }

    private void loadOneWeekFoodItems() {
        foodDiaryDatabaseReference = FirebaseDatabase.getInstance("https://nutriflow-48394-default-rtdb.firebaseio.com").getReference().child("FoodDiaries");


        if (firebaseAuth.getCurrentUser()!=null) {
            currentUserID = firebaseAuth.getCurrentUser().getUid();
        }
        GetUserFoodData(currentUserID);


    }


    private DatabaseReference foodDiaryDatabaseReference;
    private long diariesFoodCount, diariesWorkoutCount;
    private List<String> last7DaysFoodItems = new ArrayList<>();

    private void GetUserFoodData(final String userID) {
        foodDiaryDatabaseReference.child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    diariesFoodCount = dataSnapshot.getChildrenCount();

                    // Define the date format used in Firebase
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

                    // Get today's date
                    Calendar calendar = Calendar.getInstance();
                    Date today = calendar.getTime();

                    // Go back 7 days
                    calendar.add(Calendar.DAY_OF_YEAR, -7);
                    Date lastWeek = calendar.getTime();

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String dateStr = ds.getKey();
                        try {
                            // Parse the date from the string
                            Date recordDate = sdf.parse(dateStr);

                            // Check if the date is within the last 7 days
                            if (recordDate != null && !recordDate.before(lastWeek) && !recordDate.after(today)) {
                                Log.e("Valid date", dateStr);

                                // Add another listener to retrieve data for valid dates
                                foodDiaryDatabaseReference.child(userID).child(dateStr).addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                last7DaysFoodItems.add(snapshot.getKey().replace("_"," "));
                                            }
                                        }



                                        getGroceeryItemsReccomendations(last7DaysFoodItems);

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        Log.e("Firebase Error", databaseError.getMessage());
                                    }
                                });
                            }
                        } catch (ParseException e) {
                            Log.e("Date Parsing Error", "Error parsing date: " + dateStr);
                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase Error", databaseError.getMessage());
            }
        });
    }

    private void getGroceeryItemsReccomendations(List<String> last7DaysFoodItems) {



        // Initialize your TextViews
        mustNeededTextView = findViewById(R.id.must_needed_items);
        neededTextView = findViewById(R.id.needed_items);
        leastNeededTextView = findViewById(R.id.least_needed_items);

        // Call the API
        GroceeryRecoService service = new GroceeryRecoService();
         service.getGroceryList(last7DaysFoodItems, this);

    }



    @Override
    public void onSuccess(JSONArray mustNeeded, JSONArray needed, JSONArray leastNeeded) {
        runOnUiThread(() -> {
            // Convert JSONArray to String and format for display
            String mustNeededList = formatGroceryItems(mustNeeded);
            String neededList = formatGroceryItems(needed);
            String leastNeededList = formatGroceryItems(leastNeeded);

            // Update UI with the response data
            mustNeededTextView.setText("Must Needed Items:\n" + mustNeededList);
            neededTextView.setText("Needed Items:\n" + neededList);
            leastNeededTextView.setText("Least Needed Items:\n" + leastNeededList);
        });
    }

    // Helper method to format the JSONArray into a readable String
    private String formatGroceryItems(JSONArray items) {
        StringBuilder formattedItems = new StringBuilder();
        for (int i = 0; i < items.length(); i++) {
            try {
                // Append each item with a bullet point or new line
                formattedItems.append("• ").append(items.getString(i)).append("\n");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return formattedItems.toString();
    }


    @Override
    public void onFailure(String errorMessage) {
        runOnUiThread(() -> Toast.makeText(MainActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show());
    }


    private void UserSendToSetupPage() {
        Intent SetupIntent = new Intent(MainActivity.this, SetupActivity.class);
        SetupIntent.putExtra("IntentFrom", "ProfileFragment");
        startActivity(SetupIntent);
    }


    /* Add validation for users */
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser == null) {
            UserSendToWelcomePage();
        }
    }


    /* retrieve user image to tool bar from firebase database */
    private void SetToolbarUserImage() {
        currentUserID = firebaseAuth.getCurrentUser().getUid();
        userDatabaseReference = FirebaseDatabase.getInstance("https://nutriflow-48394-default-rtdb.firebaseio.com/").getReference().child("Users").child(currentUserID);
        userDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    if (dataSnapshot.hasChild("userimage")) {

                        String image = dataSnapshot.child("userimage").getValue().toString();
                        if (!(image.equals(""))) {
                            Picasso.with(MainActivity.this).load(image).placeholder(R.drawable.default_user_image).into(toolbarUserImage);
                        }

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    /* Redirect user to the welcome page */
    private void UserSendToWelcomePage() {
        Intent welcomeIntent = new Intent(MainActivity.this, WelcomeActivity.class);
        welcomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); /* Barrier for go back to main activity */
        startActivity(welcomeIntent);
        finish();
    }


    /* toolbar back button click action */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public void onButtonClick(String foodId, String intentFromOther) {
        this.intentFrom = intentFromOther;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Source of Food");
        builder.setItems(new CharSequence[]{"Camera", "Gallery", "Manual Food"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0: // Camera
                        openCamera();
                        break;
                    case 1: // Gallery
                        openGallery();
                        break;
                    case 2: // Manual Food
                        Intent foodListIntent = new Intent(MainActivity.this, FoodListActivity.class);
                        foodListIntent.putExtra("intentFrom", intentFrom);
                        startActivity(foodListIntent);
                        break;
                }
            }
        });
        builder.show();
    }


    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_CAMERA_CAPTURE);
        }
    }

    // Modify onActivityResult to handle camera capture result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            // Handle gallery image selection
            Uri selectedImageUri = data.getData();
            Bitmap bitmap = convertUriToBitmap(selectedImageUri);
            byte[] imageData = convertBitmapToByteArray(bitmap);


            // Call the Retrofit API
            sendImageToServer(imageData);
        } else if (requestCode == REQUEST_CAMERA_CAPTURE && resultCode == RESULT_OK && data != null) {
            // Handle camera capture result
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            byte[] imageData = convertBitmapToByteArray(imageBitmap);

            // Call the Retrofit API
            sendImageToServer(imageData);
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }


    private Bitmap convertUriToBitmap(Uri uri) {
        try {
            InputStream inputStream = getContentResolver().openInputStream(uri);
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    private void sendImageToServer(byte[] imageData) {
        String baseUrl = "http://backendcode.pythonanywhere.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getCustomOkHttpClient())  // Set custom OkHttpClient with timeout
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        // Create a MultipartBody.Part from the image data
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), imageData);
        MultipartBody.Part imagePart = MultipartBody.Part.createFormData("image", "image.jpg", requestBody);

        // Show a loading bar
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading Image...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        // Call the API
        Call<ApiResponse> call = apiInterface.uploadImage(imagePart);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                progressDialog.dismiss();  // Dismiss loading bar
                Log.e("response: ", response.toString());
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
                    // Handle the API response, show result dialog or update UI
                    showResultDialog(apiResponse);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to upload image", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                progressDialog.dismiss();  // Dismiss loading bar
                Toast.makeText(MainActivity.this, "Network error " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private OkHttpClient getCustomOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)  // Set your desired timeout values
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    private void showResultDialog(ApiResponse apiResponse) {
        Log.e("Response ", apiResponse.getLabel().toString());
        ArrayList<FoodDetails> foodDetails = new ArrayList<FoodDetails>();
        Bitmap processedBitmap = null;
        HashMap<String, FoodDetails> allFood = FoodInformation.addFoods();


        for (String food : apiResponse.getLabel().split((","))) {
            if (food.isEmpty()== false) {
                if (foodDetails.contains(allFood.get(food.trim())) != true) {
                    Log.e("allFood.",allFood.toString());
                    FoodDetails foodDetailsSng = allFood.get(food.trim());

                    Log.e("foodDetailsSng.",foodDetailsSng.toString());

                    foodDetailsSng.setDescription(food.trim() + " splitme "+foodDetailsSng.getDescription());
                    foodDetails.add(foodDetailsSng);
                }
            }
        }
        // If processed_image is not null, display the processed image in the dialog
        if (apiResponse.getProcessed_image() != null && !apiResponse.getProcessed_image().isEmpty()) {
            // Decode the base64 string to a Bitmap
            processedBitmap = decodeBase64(apiResponse.getProcessed_image());

        }

        Intent intent = new Intent(this, DisplayFoodNutritionsActivity.class);
        // Pass the ArrayList<FoodDetails> to the second activity
        intent.putParcelableArrayListExtra("foodDetails", (ArrayList<? extends Parcelable>) foodDetails);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        processedBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        intent.putParcelableArrayListExtra("foodDetails", foodDetails);
        intent.putExtra("processedBitmap", byteArray);
        intent.putExtra("intentFrom", intentFrom);

        // Start the second activity
        startActivity(intent);


    }

    private Bitmap decodeBase64(String base64String) {
        byte[] decodedBytes = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

}
