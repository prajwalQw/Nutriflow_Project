package com.example.nutriflow.detection;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutriflow.MainActivity;
import com.example.nutriflow.R;

import java.util.ArrayList;

public class DisplayFoodNutritionsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food_nutritions);
        imageView = findViewById(R.id.foodImage);

        // Retrieve the ArrayList<FoodDetails>
        ArrayList<FoodDetails> productList = getIntent().getParcelableArrayListExtra("foodDetails");
        if (productList.isEmpty()) {
            Toast.makeText(this, "Please try with some other images.. :)", Toast.LENGTH_SHORT).show();
        }

        // Retrieve the processed Bitmap

// Retrieve the byte array of the processed Bitmap
        byte[] byteArray = getIntent().getByteArrayExtra("processedBitmap");

// Convert the byte array back to a Bitmap
        Bitmap processedBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        imageView.setImageBitmap(processedBitmap);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri imageUri = ImageUtils.saveImageToGallery(DisplayFoodNutritionsActivity.this, processedBitmap, "ImageTitle", "ImageDescription");

                if (imageUri != null) {
                    Intent viewImageIntent = new Intent(Intent.ACTION_VIEW);
                    viewImageIntent.setDataAndType(imageUri, "image/*");
                    viewImageIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(viewImageIntent);

                }
            }
        });

        recyclerView = findViewById(R.id.recycler_view);

        FoodItemAdapter itemAdapter = new FoodItemAdapter(productList, getApplicationContext(), String.valueOf(getIntent().getExtras().get("intentFrom")));
        GridLayoutManager gridLayout = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(gridLayout);

        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}