package com.example.project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.models.Product;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import API.FirebaseAPI;

public class post extends AppCompatActivity {
    private static final int CHOOSE_IMAGE = 101;
    ImageView display_image1;
    EditText Product_name_pv1, quntity1,  Price1, product_status1;
    TextView description1;
    Spinner catagory1;

    Button postt1;
    Uri uriImg;
    Product product =new Product();
    FirebaseAPI firebaseAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        display_image1 = findViewById(R.id.display_image1);
        Product_name_pv1 = findViewById(R.id.Product_name_pv1);
        quntity1 = findViewById(R.id.quntity1);
        Price1 = findViewById(R.id.Price1);
        product_status1 = findViewById(R.id.product_status1);
        description1 = findViewById(R.id.description1);
        catagory1 = findViewById(R.id.catagory1);
        postt1 = findViewById(R.id.postt1);
        // Define values and corresponding names
        List<String> values = new ArrayList<>();
        values.add("Select");
        values.add("Sofa");
        values.add("Cabinets");
        values.add("Ovens");
        values.add("Iron Beds");
        values.add("Mattresses");
        values.add("Fridges");
        values.add("Electrical Devices");
        values.add("Desks");



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        catagory1.setAdapter(adapter);

        display_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getImage();
            }
        });


        postt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    if(isInputComplete()){
                        //API_CALLING
                        try {
                            firebaseAPI.add_item(product,post.this);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else{
                        Toast.makeText(post.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        });

    }
    private void getImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "choose"), CHOOSE_IMAGE);

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uriImg = data.getData();
            product.setImage(uriImg.toString());
         firebaseAPI = new FirebaseAPI(post.this);
            firebaseAPI.uploadImg(post.this,uriImg);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uriImg);
                display_image1.setImageBitmap(bitmap);

            } catch (Exception e) {

            }
        }
    }
    private boolean  isInputComplete() throws JSONException {
        if(Product_name_pv1.getText().equals(null)){
            Toast.makeText(post.this, "Please Enter a Product Name", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            product.setName(Product_name_pv1.getText().toString());
        }
        if(quntity1.getText().equals(null)){
            Toast.makeText(post.this, "Please Enter a Quantity", Toast.LENGTH_SHORT).show();
            return false;

        }else{
            product.setQuantity(quntity1.getText().toString());
        }
        if(Price1.getText().equals(null)){
            Toast.makeText(post.this, "Please Enter a Price", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            product.setPrice(Price1.getText().toString());
        }
        if(product_status1.getText().equals(null)){
            Toast.makeText(post.this, "Please Enter a Status", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            product.setStatus(product_status1.getText().toString());
        }
         if(description1.getText().equals(null)){
            Toast.makeText(post.this, "Please Enter a Status", Toast.LENGTH_SHORT).show();
             product.setDescription("");
        }else{
            product.setDescription(product_status1.getText().toString());
        }
        boolean b = catagory1.isSelected();
         if(!b){
             int position = catagory1.getSelectedItemPosition();
             String s = String.valueOf(position);
             product.setCatagory(s);
             return true;
         }else {
             Toast.makeText(post.this, "Please Enter a category", Toast.LENGTH_SHORT).show();
             return false;

         }











    }




}