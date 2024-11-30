package com.example.nutriflow;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GroceeryRecoService {

    private static final String TAG = "ApiService";
    private static final String BASE_URL = "http://backendcode.pythonanywhere.com/grocery-list";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient();

    public void getGroceryList(List<String> foodList, GroceryCallback callback) {
        // Convert the list of food items to a JSON array
        JSONArray foodArray = new JSONArray(foodList);

        // Create JSON object for the request body
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("food_list", foodArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Create the request body
        RequestBody requestBody = RequestBody.create(jsonObject.toString(), JSON);

        // Build the request
        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(requestBody)
                .build();

        // Enqueue the request for asynchronous execution
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Request failed: " + e.getMessage());
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    Log.d(TAG, "Response: " + responseData);

                    try {
                        JSONObject jsonResponse = new JSONObject(responseData);
                        JSONArray mustNeeded = jsonResponse.getJSONArray("Must Needed Items");
                        JSONArray needed = jsonResponse.getJSONArray("Needed Items");
                        JSONArray leastNeeded = jsonResponse.getJSONArray("Least Needed Items");

                        // Pass data to callback
                        callback.onSuccess(mustNeeded, needed, leastNeeded);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        callback.onFailure("Failed to parse JSON response.");
                    }
                } else {
                    callback.onFailure("Request failed with code: " + response.code());
                }
            }
        });
    }
}
