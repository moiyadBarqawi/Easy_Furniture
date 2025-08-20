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
import com.example.project.databinding.LikeRowBinding;
import com.example.project.databinding.ProductBinding;
import com.example.project.models.likedModel;

import java.util.List;

public class likedAdapter extends RecyclerView.Adapter<likedAdapter.Liked_holder> {

    Context context;
    List<likedModel> likes;

    public likedAdapter(Context context, List<likedModel> likes) {
        this.context = context;
        this.likes = likes;
    }

    @NonNull
    @Override
    public Liked_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new likedAdapter.Liked_holder(LayoutInflater.from(context).inflate(R.layout.like_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Liked_holder holder, int position) {
        holder.getLikedimgv().setImageResource(likes.get(position).getImg1());
        holder.getLikedname().setText(likes.get(position).getName());
        holder.getLikedprice().setText(likes.get(position).getPrice());
        holder.getItemdel1().setImageResource(likes.get(position).getImg2());
        holder.getBtnaddbtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to cart
            }
        });

    }

    @Override
    public int getItemCount() {
        return likes.size();
    }

    public static class Liked_holder extends RecyclerView.ViewHolder{
        ImageView likedimgv, itemdel1;
        TextView likedname, likedprice;

        Button btnaddbtn;


        public Liked_holder (@NonNull View itemView) {
            super(itemView);
            likedimgv = itemView.findViewById(R.id.likedimgv);
            itemdel1 = itemView.findViewById(R.id.itemdel1);
            likedname = itemView.findViewById(R.id.likedname);
            likedprice = itemView.findViewById(R.id.likedprice);
            btnaddbtn = itemView.findViewById(R.id.btnaddbtn);
        }

        public ImageView getLikedimgv() {
            return likedimgv;
        }

        public void setLikedimgv(ImageView likedimgv) {
            this.likedimgv = likedimgv;
        }

        public ImageView getItemdel1() {
            return itemdel1;
        }

        public void setItemdel1(ImageView itemdel1) {
            this.itemdel1 = itemdel1;
        }

        public TextView getLikedname() {
            return likedname;
        }

        public void setLikedname(TextView likedname) {
            this.likedname = likedname;
        }

        public TextView getLikedprice() {
            return likedprice;
        }

        public void setLikedprice(TextView likedprice) {
            this.likedprice = likedprice;
        }

        public Button getBtnaddbtn() {
            return btnaddbtn;
        }

        public void setBtnaddbtn(Button btnaddbtn) {
            this.btnaddbtn = btnaddbtn;
        }
    }
}
