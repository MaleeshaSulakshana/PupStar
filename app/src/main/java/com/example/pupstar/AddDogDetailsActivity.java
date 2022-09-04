package com.example.pupstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddDogDetailsActivity extends AppCompatActivity {

    private Button btnNext, btnResetImage,btnSave;
    private LinearLayout detailView, detectionView;
    private ImageView selectedImage;
    private Spinner petType, genderType;

    private ArrayList<String> petsItemsArray = new ArrayList<String>();
    private ArrayAdapter<String> petsAdapter;

    private ArrayList<String> genderItemsArray = new ArrayList<String>();
    private ArrayAdapter<String> genderAdapter;

    private String selectedPetType = "", selectedGenderType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog_details);

        btnResetImage = (Button) findViewById(R.id.btnResetImage);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnSave = (Button) findViewById(R.id.btnSave);

        detailView = (LinearLayout) findViewById(R.id.detailView);
        detectionView = (LinearLayout) findViewById(R.id.detectionView);

        selectedImage = (ImageView) findViewById(R.id.selectedImage);

        petType = (Spinner) findViewById(R.id.petType);
        genderType = (Spinner) findViewById(R.id.genderType);

        detectionView.setVisibility(View.VISIBLE);
        detailView.setVisibility(View.GONE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                detectionView.setVisibility(View.GONE);
                detailView.setVisibility(View.VISIBLE);

            }
        });

        petType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                selectedPetType = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        genderType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                selectedGenderType = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        petsItemsArray.add("Choose your pet type");
        petsItemsArray.add("Dog");

        petsAdapter = new ArrayAdapter<String>(AddDogDetailsActivity.this,
                R.layout.spinner_row, petsItemsArray);
        petsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        petType.setAdapter(petsAdapter);
        petType.setSelection(0);

        genderItemsArray.add("Male");
        genderItemsArray.add("Female");

        genderAdapter = new ArrayAdapter<String>(AddDogDetailsActivity.this,
                R.layout.spinner_row, genderItemsArray);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        genderType.setAdapter(genderAdapter);
        genderType.setSelection(0);

    }
}