package com.example.nutriflow;

import org.json.JSONArray;

public interface GroceryCallback {
    void onSuccess(JSONArray mustNeeded, JSONArray needed, JSONArray leastNeeded);
    void onFailure(String errorMessage);
}
