package com.example.pupstar.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.pupstar.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


public class AppointmentsFragment extends Fragment {

    private ChipGroup chipGroup;
    private LinearLayout layoutUpcoming, layoutPrevious;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_appointments, container, false);

        chipGroup = (ChipGroup) view.findViewById(R.id.chipGroup);

        layoutUpcoming = (LinearLayout) view.findViewById(R.id.layoutUpcoming);
        layoutPrevious = (LinearLayout) view.findViewById(R.id.layoutPrevious);

        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup chipGroup, int i) {

                Chip chip = chipGroup.findViewById(i);
                if (chip != null) {
                    String selected = chip.getText().toString();

                    if (selected.equals("Upcoming")) {
                        showUpcoming();
                    } else {
                        showPrevious();
                    }

                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void showUpcoming()
    {
        layoutUpcoming.setVisibility(View.VISIBLE);
        layoutPrevious.setVisibility(View.GONE);
    }

    private void showPrevious()
    {
        layoutPrevious.setVisibility(View.VISIBLE);
        layoutUpcoming.setVisibility(View.GONE);
    }
}