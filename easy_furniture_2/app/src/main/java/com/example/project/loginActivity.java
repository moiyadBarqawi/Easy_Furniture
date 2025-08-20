package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;

import API.FirebaseAPI;
import datamodel.User;

public class loginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button  loginbtn;
    // Define your API endpoint URL
    private static final String LOGIN_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize EditText fields
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.Password);
        loginbtn = findViewById(R.id.loginButton);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClick(view);
            }
        });
    }

    // Method to handle login button click
    public void onLoginClick(View view) {
        // Retrieve email and password from EditText fields
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Perform basic validation
        if (email.isEmpty() || password.isEmpty()) {
            // Show a toast indicating input error if email or password is empty
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
        } else {


            // Call FirebaseAPI to register the user
            FirebaseAPI firebaseAPI = new FirebaseAPI(loginActivity.this);
            try {
                firebaseAPI.login(email,password, loginActivity.this);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    // Method to handle Sign Up text click
    public void onSignupClick(View view) {
        Intent intent = new Intent(loginActivity.this, signupActivity.class);
        startActivity(intent);
    }
}
