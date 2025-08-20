package com.example.project;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Catagory_holder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView;

    public Catagory_holder (@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.catagoryimage);
        nameView = itemView.findViewById(R.id.name);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getNameView() {
        return nameView;
    }

    public void setNameView(TextView nameView) {
        this.nameView = nameView;
    }
}
