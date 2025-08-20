package com.example.project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Productactivity extends AppCompatActivity {

    TextView Product_name_pv2,description2, quntity2, Price2, product_status2,product_cat2;
    Button postt2;
    ImageView imgloved, display_image2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Product_name_pv2 = findViewById(R.id.Product_name_pv2);
        description2 = findViewById(R.id.description2);
        quntity2 = findViewById(R.id.quntity2);
        Price2 = findViewById(R.id.Price2);
        product_status2 = findViewById(R.id.product_status2);
        product_cat2 = findViewById(R.id.product_cat2);
        postt2 = findViewById(R.id.postt2);
        imgloved = findViewById(R.id.imgloved);
        display_image2 = findViewById(R.id.display_image2);

    }
}
