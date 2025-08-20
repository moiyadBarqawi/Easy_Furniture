package API;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project.GitStartedActivity;
import com.example.project.MainActivity;
import com.example.project.R;
import com.example.project.UserProfileActivity;
import com.example.project.loginActivity;
import com.example.project.models.Product;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import datamodel.User;

public class FirebaseAPI {
    static String URL = "http://192.168.1.2:5000/";
    String profileUrl = "";

    private RequestQueue queue;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FirebaseAPI(Context context) {
        queue = Volley.newRequestQueue(context);

    }

    public void register(User user, Context context) throws JSONException {
        String url = URL + "user";


        try {

            // Make new json object and put params in it
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("name", user.getName());
            jsonParams.put("location", user.getLocation());
            jsonParams.put("birthday", user.getBirthday());
            jsonParams.put("email", user.getEmail());
            jsonParams.put("password", user.getPassword());


            // Building a request
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL + "user",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "error occurred", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }) {
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonParams.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };


            queue.add(stringRequest);

        } catch (JSONException ex) {
            throw ex;
        }


    }

    public void login(String email, String password, Context context) throws JSONException {


        try {

            // Make new json object and put params in it
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("email", email);
            jsonParams.put("password", password);


            // Building a request
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL + "login",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("false")) {
                                Toast.makeText(context, "wrong confidentials", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show();
                                //change the login to your landing page once you uploaded it to githup
                                Intent intent = new Intent(context, MainActivity.class);
                                intent.putExtra("id", response);
                                startActivity(context, intent, null);
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }) {
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonParams.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };


            queue.add(stringRequest);

        } catch (JSONException ex) {
            throw ex;
        }


    }

    public void get_user_data(String id, Context context) throws JSONException {
        String url = URL + "profile";


        try {

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("id", id);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL + "profile",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            TextView nameTextView = (TextView) ((Activity) context).findViewById(R.id.textView_show_full_name);
                            TextView dateTextView = (TextView) ((Activity) context).findViewById(R.id.textView_show_dob);
                            TextView locationTextView = (TextView) ((Activity) context).findViewById(R.id.textView_show_gender);
                            TextView emailTextView = (TextView) ((Activity) context).findViewById(R.id.textView_show_email);
                            Button selectImageButton = (Button) ((Activity) context).findViewById(R.id.selectImageButton);

                            try {
                                JSONObject obj = new JSONObject(response);
                                String name = obj.getString("name");
                                String date = obj.getString("birthday");
                                String location = obj.getString("location");
                                String email = obj.getString("email");
                                nameTextView.setText(name);
                                dateTextView.setText(date);
                                locationTextView.setText(location);
                                emailTextView.setText(email);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "error occurred", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }) {
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonParams.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };


            queue.add(stringRequest);

        } catch (JSONException ex) {
            throw ex;
        }


    }

    public void uploadImg(Context context, Uri uriImg) {
        StorageReference imgRef = FirebaseStorage.getInstance().getReference("itemPic/" + System.currentTimeMillis() + ".jpg");
        imgRef.putFile(uriImg).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(context, "image uploaded successfully  ", Toast.LENGTH_SHORT).show();
                //profileUrl= taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        profileUrl = uri.toString();

                    }
                });
            }
        });


    }
    public void add_item(Product product, Context context) throws JSONException {


        try {

            // Make new json object and put params in it
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("name", product.getName());
            jsonParams.put("category", product.getCatagory());
            jsonParams.put("picture", product.getImage());
            jsonParams.put("description", product.getDescription());
            jsonParams.put("quantity", product.getQuantity());
            jsonParams.put("status", product.getStatus());
            jsonParams.put("price", product.getPrice());

            // Building a request
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL + "addItem",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(context, "Item Added !", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(context, "error occurred", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }) {
                @Override
                public byte[] getBody() throws AuthFailureError {
                    return jsonParams.toString().getBytes(StandardCharsets.UTF_8);
                }

                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };


            queue.add(stringRequest);

        } catch (JSONException ex) {
            throw ex;
        }


    }
}