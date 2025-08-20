package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Adabters.AdapterCart;
import com.example.project.Adabters.CatagorAdabter;

import com.example.project.models.Catagory;
import com.example.project.databinding.ActivityCartBinding;
import com.example.project.models.ModelCart;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {


    Intent intent;
    private ArrayList<ModelCart> cart;
    ActivityCartBinding binding;
    TextView carts;
    Button check1btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        carts = findViewById(R.id.carts);
        check1btn = findViewById(R.id.check1btn);
        cartSetUp();

    }



    private void cartSetUp() {// this is for cart adding
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.cartView.setLayoutManager(linearLayoutManager);

        cart = new ArrayList<>();
        cart.add(new ModelCart("Sectional Sofa", "200", R.drawable.sofa1, 1));
        cart.add(new ModelCart("Chesterfield cabinet", "200", R.drawable.cabinet1, 2));
        cart.add(new ModelCart("Lawson Sofa",  "200", R.drawable.sofa1, 1));



        AdapterCart adapter = new AdapterCart(this, cart);
        binding.cartView.setAdapter(adapter);
    }


}