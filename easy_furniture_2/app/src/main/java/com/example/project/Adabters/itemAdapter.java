package com.example.project.Adabters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import com.example.project.R;
import com.example.project.databinding.ItemRowBinding;
import com.example.project.models.ItemsModel;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.Items_holder> {

    Context context;
    List<ItemsModel> items;

    public itemAdapter(Context context, List<ItemsModel> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public Items_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Items_holder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Items_holder holder, int position) {
        holder.binding.itemimg1.setImageResource(items.get(position).getImg1());
        holder.binding.itemlove.setImageResource(items.get(position).getImg2());
        holder.binding.txtprice1.setText(items.get(position).getPrice());
        holder.binding.nameItem.setText(items.get(position).getName());
        holder.binding.addTxt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent

            }
        });
        holder.binding.addTxt3.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_HOVER_ENTER:
                        holder.getAdd_txt3().setTextColor(ContextCompat.getColor(context, R.color.white));
                        break;
                    case MotionEvent.ACTION_HOVER_EXIT:
                        holder.getAdd_txt3().setTextColor(ContextCompat.getColor(context, R.color.black));
                        break;
                }

                return true;
            }
        });

        holder.binding.itemlove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.itemlove.setImageResource(R.drawable.fullheart);
            }
        });
//        holder.binding.likelottie1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //holder.getLikelottie1().playAnimation();
//                //toast
//            }
//        });

//        holder.getItemimg1().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //intent
//            }
//        });




    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Items_holder extends RecyclerView.ViewHolder{

        ImageView itemimg1, itemlove;
        TextView txtprice1, name_item;

        TextView add_txt3;




        ItemRowBinding binding;
        public Items_holder(@NonNull View itemView) {
            super(itemView);
            binding = ItemRowBinding.bind(itemView);
            itemimg1 = itemView.findViewById(R.id.itemimg1);
            txtprice1 = itemView.findViewById(R.id.txtprice1);
            add_txt3 = itemView.findViewById(R.id.add_txt3);
            itemlove = itemView.findViewById(R.id.itemlove);
            name_item = itemView.findViewById(R.id.name_item);


        }

        public ImageView getItemimg1() {
            return itemimg1;
        }

        public void setItemimg1(ImageView itemimg1) {
            this.itemimg1 = itemimg1;
        }



        public TextView getTxtprice1() {
            return txtprice1;
        }

        public void setTxtprice1(TextView txtprice1) {
            this.txtprice1 = txtprice1;
        }


        public TextView getAdd_txt3() {
            return add_txt3;
        }

        public void setAdd_txt3(TextView add_txt3) {
            this.add_txt3 = add_txt3;
        }

        public ImageView getItemlove() {
            return itemlove;
        }

        public void setItemlove(ImageView itemlove) {
            this.itemlove = itemlove;
        }

        public TextView getName_item() {
            return name_item;
        }

        public void setName_item(TextView name_item) {
            this.name_item = name_item;
        }
    }

}
