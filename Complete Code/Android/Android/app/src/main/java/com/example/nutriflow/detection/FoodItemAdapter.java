package com.example.nutriflow.detection;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutriflow.AddFoodActivity;
import com.example.nutriflow.Foods;
import com.example.nutriflow.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.ItemViewHolder> {

    private ArrayList<FoodDetails> mItemList;
    private Context mcontext;
    String intentFrom;
    private DatabaseReference userDatabaseReference, foodDiaryDatabaseReference, foodDatabaseReference, waterDiaryDatabaseReference;

    public FoodItemAdapter(@NonNull ArrayList<FoodDetails> ItemList, Context context, String intentFrom) {
        this.mItemList = ItemList;
        this.mcontext = context;
        this.intentFrom = intentFrom;
        foodDatabaseReference = FirebaseDatabase.getInstance("https://nutriflow-48394-default-rtdb.firebaseio.com").getReference().child("Foods");
    }

    //This method will filter the list
    //here we are passing the filtered data
    //and assigning it to the list with notify dataset changed method

    public void filterList(ArrayList<FoodDetails> ItemList) {
        this.mItemList = ItemList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {

        // get product one by one
        final FoodDetails item = mItemList.get(position);
        String foodCode = item.getDescription().split(" splitme ")[0].trim();
        item.setDescription(item.getDescription().split(" splitme ")[1]);
        String foodNam = item.getDescription().split(" is ")[0];
        holder.foodName.setText((String) foodNam);
        holder.foodDetails.setText((String) item.getDescription());
        holder.carbohydrates.setText((String) item.getDescription());
        holder.fat.setText(item.getNutritionalInformation().getFat() + " g");
        holder.protein.setText(item.getNutritionalInformation().getProtein() + " g");
        holder.calories.setText(item.getNutritionalInformation().getCalories() + " g");
        holder.carbohydrates.setText(item.getNutritionalInformation().getCarbohydrates() + " g");

        holder.addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFoodIdAndSendIntent(intentFrom,foodCode);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {


        private TextView calories, fat, foodName, foodDetails, protein, carbohydrates;
        private CardView addFood;


        public ItemViewHolder(View itemView) {
            super(itemView);
//
            foodName = itemView.findViewById(R.id.foodName);
            foodDetails = itemView.findViewById(R.id.foodDetails);
            carbohydrates = itemView.findViewById(R.id.carbohydrates);
            fat = itemView.findViewById(R.id.fat);
            calories = itemView.findViewById(R.id.calories);
            protein = itemView.findViewById(R.id.protein);
            addFood = itemView.findViewById(R.id.addFood);


        }

    }


    private void getFoodIdAndSendIntent(String intentFrom, String foodCode) {
        Query searchFoodQuery = foodDatabaseReference.orderByChild("foodsearchkeyword").startAt("").endAt("" + "\uf8ff");
        searchFoodQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method will be called whenever there is data available
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Get the data from each child snapshot
                    // Assuming the data model for your data is of type FoodItem
                    Foods foodItem = snapshot.getValue(Foods.class);
                    if (foodItem.getFoodsearchkeyword().toString().equalsIgnoreCase(foodCode) || foodItem.getFoodname().toString().equalsIgnoreCase(foodCode)) {
                        final String FoodID = snapshot.getKey();
                        if (!intentFrom.equals("ProfileMenu")) {
                            Intent addFoodIntent = new Intent(mcontext, AddFoodActivity.class);
                            addFoodIntent.putExtra("intentFrom", intentFrom);
                            addFoodIntent.putExtra("intentFoodID", FoodID);
                            addFoodIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                            mcontext.startActivity(addFoodIntent);
                        } else {
                            Intent addFoodIntent = new Intent(mcontext, AddFoodActivity.class);
                            addFoodIntent.putExtra("intentFrom", intentFrom);
                            addFoodIntent.putExtra("intentFoodID", FoodID);
                            addFoodIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                            mcontext.startActivity(addFoodIntent);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle any potential errors here
                System.err.println("Error fetching data: " + databaseError.getMessage());
            }
        });
    }


}// End of class
