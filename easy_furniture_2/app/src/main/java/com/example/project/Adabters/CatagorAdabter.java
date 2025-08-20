package com.example.project.Adabters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.models.Catagory;
import com.example.project.Catagory_holder;
import com.example.project.R;

public class CatagorAdabter extends RecyclerView.Adapter<Catagory_holder> {


    Context context;
    List<com.example.project.models.Catagory> Catagory;

    public CatagorAdabter(Context context, List<Catagory> catagory) {
        this.context = context;
        this.Catagory = catagory;
    }

    @NonNull
    @Override
    public Catagory_holder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new Catagory_holder(LayoutInflater.from(context).inflate(R.layout.catagoriesraw,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  Catagory_holder holder, int position) {
        holder.getNameView().setText(Catagory.get(position).getName());
        holder.getImageView().setImageResource(Catagory.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return Catagory.size();
    }
}