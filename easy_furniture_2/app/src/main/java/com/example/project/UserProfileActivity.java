package com.example.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import API.FirebaseAPI;
import datamodel.User;



public class UserProfileActivity extends AppCompatActivity {

    ImageView imageView_profile_dp;
    TextView textView_show_welcome, textView_show_full_name, textView_show_email, textView_show_dob, textView_show_gender ;
    Button selectImageButton;
    private static final int PICK_IMAGE_REQUEST = 1;
    Bitmap bitmap;
    String ID="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ID = extras.getString("id");
            setContentView(R.layout.activity_user_profile);

            // Initialize views
            imageView_profile_dp = findViewById(R.id.imageView_profile_dp);
            textView_show_welcome = findViewById(R.id.textView_show_welcome);
            textView_show_full_name = findViewById(R.id.textView_show_full_name);
            textView_show_email = findViewById(R.id.textView_show_email);
            textView_show_dob = findViewById(R.id.textView_show_dob);
            textView_show_gender = findViewById(R.id.textView_show_gender);
            selectImageButton = findViewById(R.id.selectImageButton);

            // Set click listener for select image button

            selectImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Open gallery to select image
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                }
            });

            fetchUserDataFromAPI();
        }
    }
    // Method to fetch user data from FirebaseAPI
    private void fetchUserDataFromAPI() {
        FirebaseAPI firebaseAPI = new FirebaseAPI(this);
        try {
            firebaseAPI.get_user_data(ID,this);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    // Handle the result of picking an image from the gallery
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Get the image URI from the intent
            // Set the image to the image view
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(data.getData()));
                imageView_profile_dp.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
