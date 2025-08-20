package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.project.Adabters.CatagorAdabter;
import com.example.project.Adabters.likedAdapter;
import com.example.project.databinding.ActivityLikesBinding;
import com.example.project.databinding.ActivityMainBinding;
import com.example.project.models.Catagory;
import com.example.project.models.ItemsModel;
import com.example.project.models.likedModel;

import java.util.ArrayList;

public class likes extends AppCompatActivity {

    TextView liked;
    private ArrayList<likedModel> likes;

    ActivityLikesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLikesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        liked = findViewById(R.id.liked);


    }

    private void likedSetUp() {// this is for catagories adding
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.itemRecycler.setLayoutManager(linearLayoutManager);

        likes = new ArrayList<>();
        likes.add(new likedModel(R.drawable.sofa1, R.drawable.fullheart, "Sofa", "100"));
        likes.add(new likedModel(R.drawable.cabinet1, R.drawable.fullheart, "cabinet", "100"));



        likedAdapter adapter = new likedAdapter(this, likes);
        binding.itemRecycler.setAdapter(adapter);
    }

}