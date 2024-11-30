package com.example.nutriflow.detection;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Multipart
    @POST("/predict") // Adjust this endpoint based on your Flask API
    Call<ApiResponse> uploadImage(@Part MultipartBody.Part image);
}
