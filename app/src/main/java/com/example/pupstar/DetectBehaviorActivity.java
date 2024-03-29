package com.example.pupstar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DetectBehaviorActivity extends AppCompatActivity {

    private Button btnAnalyse, btnResetImage;
    private LinearLayout selectDetectionImage;
    private ImageView petImage, btnBack;

    private static final int PICK_IMAGE = 100;
    private Uri imageUri = Uri.EMPTY;
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detect_behavior);

        btnResetImage = (Button) findViewById(R.id.btnResetImage);
        btnAnalyse = (Button) findViewById(R.id.btnAnalyse);

        selectDetectionImage = (LinearLayout) findViewById(R.id.selectDetectionImage);

        petImage = (ImageView) findViewById(R.id.petImage);
        btnBack = (ImageView) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        selectDetectionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        btnAnalyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DetectBehaviorActivity.this, ViewBehaviorDetectedResultActivity.class);
//                intent.putExtra("BitmapImage", bitmap);
                startActivity(intent);

            }
        });

    }

    private void openGallery()
    {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            try {
                bitmap = (Bitmap) MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                petImage.setImageBitmap(bitmap);

//                try {
//                    uploadProfileImage();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

//    private void uploadProfileImage() throws JSONException {
//
//        if (bitmap != null) {
//
//            String URL = API.USER_API + "/upload_breed";
//
//            String image = getStringImage(bitmap);
//            HashMap<String,String> params =  new HashMap<>();
//            params.put("image", image);
////            params.put("user_id", Preferences.LOGGED_USER_ID);
//            JSONObject parameter =  new JSONObject(params);
//            JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.POST, URL, parameter, new Response.Listener<JSONObject>() {
//                @Override
//                public void onResponse(JSONObject response) {
//
//                    try {
//
//                        String status = response.getString("status");
//                        String msg = response.getString("msg");
//
//                        Toast.makeText(AddDogDetailsActivity.this, msg, Toast.LENGTH_SHORT).show();
//
//                        bitmap = null;
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(AddDogDetailsActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
//                }
//            });
//
//
//            RequestQueue queue = Volley.newRequestQueue(this);
//            queue.add(jsonObject);
//
//        } else {
//            Toast.makeText(AddDogDetailsActivity.this, "Select profile image.", Toast.LENGTH_SHORT).show();
//        }
//
//    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;

    }

}