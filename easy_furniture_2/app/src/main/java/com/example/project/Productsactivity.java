package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project.Adabters.CatagorAdabter;
import com.example.project.Adabters.Products_Adabter;
import com.example.project.databinding.ActivityMainBinding;
import com.example.project.databinding.ActivityProductsBinding;
import com.example.project.models.Catagory;
import com.example.project.models.ItemsModel;
import com.example.project.models.Model_Product;

import java.util.ArrayList;

public class Productsactivity extends AppCompatActivity {

    private ArrayList<Model_Product> product;

    TextView cat_prod;
    ActivityProductsBinding binding;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        cat_prod = findViewById(R.id.cat_prod);
        productsSetUp();
    }

    private void productsSetUp() {// this is for catagories adding
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.itemRecycler.setLayoutManager(linearLayoutManager);

        product = new ArrayList<>();
        product.add(new Model_Product(R.drawable.sofa1, "Sofa", "100"));
        product.add(new Model_Product(R.drawable.sofa1,"Sofa", "100" ));
        product.add(new Model_Product(R.drawable.sofa1, "Sofa", "100" ));
        product.add(new Model_Product( R.drawable.sofa1, "Sofa", "100"));
        product.add(new Model_Product(R.drawable.sofa1, "Sofa", "100"));
        product.add(new Model_Product(R.drawable.sofa1, "Sofa", "100"));
        product.add(new Model_Product(R.drawable.sofa1, "Sofa", "100"));
        product.add(new Model_Product(R.drawable.sofa1, "Sofa", "100"));


        Products_Adabter adapter = new Products_Adabter(this, product);
        binding.itemRecycler.setAdapter(adapter);
    }

}
