package com.example.nutriflow.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutriflow.R;

import java.util.List;

public class MyDietPlanFoodAdapter extends RecyclerView.Adapter<MyDietPlanFoodAdapter.ViewHolder> {

    private List<String> foodList;
    private Context context;

    public MyDietPlanFoodAdapter(List<String> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_diet_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = foodList.get(position);
        holder.textView.setText(item);
        holder.itemView.findViewById(R.id.openYoutube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTube(item);
            }
        });

    }

    public void openYouTube(String searchText) {




        if (searchText.contains("(")) {
            searchText = searchText.split("\\(")[0].trim().replace("-", "").trim();
        }

        String url = "https://www.youtube.com/results?search_query="+ searchText;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.google.android.youtube");

        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // YouTube app is not installed, open in web browser instead
            intent.setPackage(null);
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtFood); // assuming the id in item_breakfast.xml is "textView"
        }
    }
}
