package com.example.nutriflow.detection;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImageUtils {

    // Save the Bitmap to a file
    public static Uri saveImageToGallery(Context context, Bitmap bitmap, String title, String description) {
        OutputStream fos;
        Uri imageUri = null;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // Use MediaStore API for Android 10 and above
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);
                values.put(MediaStore.Images.Media.TITLE, title);
                values.put(MediaStore.Images.Media.DESCRIPTION, description);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                imageUri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                fos = context.getContentResolver().openOutputStream(imageUri);
            } else {
                // Save to external storage for Android versions below 10
                File imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                File imageFile = new File(imagesDir, title + ".jpg");
                fos = new FileOutputStream(imageFile);
                imageUri = Uri.fromFile(imageFile);
            }

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();

            // Notify the gallery app of the new image
            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            mediaScanIntent.setData(imageUri);
            context.sendBroadcast(mediaScanIntent);

            Toast.makeText(context, "Image saved to gallery", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageUri;
    }
}
