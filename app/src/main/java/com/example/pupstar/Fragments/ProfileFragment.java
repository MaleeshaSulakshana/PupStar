package com.example.pupstar.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.pupstar.AddDogDetailsActivity;
import com.example.pupstar.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private Spinner genderType;

    private ArrayList<String> genderItemsArray = new ArrayList<String>();
    private ArrayAdapter<String> genderAdapter;

    private String selectedGenderType = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        genderType = (Spinner) view.findViewById(R.id.genderType);

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

        genderItemsArray.add("Male");
        genderItemsArray.add("Female");

        genderAdapter = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_row, genderItemsArray);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        genderType.setAdapter(genderAdapter);
        genderType.setSelection(0);

        return view;
    }
}