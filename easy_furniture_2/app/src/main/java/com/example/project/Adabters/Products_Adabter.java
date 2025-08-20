package com.example.project.Adabters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.databinding.ItemRowBinding;
import com.example.project.databinding.ProductBinding;
import com.example.project.models.Model_Product;

import java.util.List;

public class Products_Adabter extends RecyclerView.Adapter<Products_Adabter.Product_holder> {

    Context context;
    List<Model_Product> Products;

    public Products_Adabter(Context context, List<Model_Product> products) {
        this.context = context;
        Products = products;
    }

    @NonNull
    @Override
    public Product_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Products_Adabter.Product_holder(LayoutInflater.from(context).inflate(R.layout.product, parent, false));
    }
    //hellooo

    @Override
    public void onBindViewHolder(@NonNull Product_holder holder, int position) {
        holder.binding.likedimgvi.setImageResource(Products.get(position).getImage());
        holder.binding.likeditemname.setText(Products.get(position).getName());
        holder.binding.likeditemprice.setText(Products.get(position).getPrice());
        holder.binding.btnaddbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.binding.itemdel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    public static class Product_holder extends RecyclerView.ViewHolder {

        ImageView likedimgvi, itemdel4;
        TextView likeditemname;
        TextView likeditemprice;
        Button btnaddbtn1;


        ProductBinding binding;

        public Product_holder(@NonNull View itemView) {
            super(itemView);
            binding = ProductBinding.bind(itemView);
            likedimgvi = itemView.findViewById(R.id.likedimgvi);
            itemdel4 = itemView.findViewById(R.id.itemdel4);
            likeditemname = itemView.findViewById(R.id.likeditemname);
            likeditemprice = itemView.findViewById(R.id.likeditemprice);
            btnaddbtn1 = itemView.findViewById(R.id.btnaddbtn1);
        }

        public ImageView getLikedimgvi() {
            return likedimgvi;
        }

        public void setLikedimgvi(ImageView likedimgvi) {
            this.likedimgvi = likedimgvi;
        }

        public ImageView getItemdel4() {
            return itemdel4;
        }

        public void setItemdel4(ImageView itemdel4) {
            this.itemdel4 = itemdel4;
        }

        public TextView getLikeditemname() {
            return likeditemname;
        }

        public void setLikeditemname(TextView likeditemname) {
            this.likeditemname = likeditemname;
        }

        public TextView getLikeditemprice() {
            return likeditemprice;
        }

        public void setLikeditemprice(TextView likeditemprice) {
            this.likeditemprice = likeditemprice;
        }

        public Button getBtnaddbtn1() {
            return btnaddbtn1;
        }

        public void setBtnaddbtn1(Button btnaddbtn1) {
            this.btnaddbtn1 = btnaddbtn1;
        }

        public ProductBinding getBinding() {
            return binding;
        }

        public void setBinding(ProductBinding binding) {
            this.binding = binding;
        }
    }
}

