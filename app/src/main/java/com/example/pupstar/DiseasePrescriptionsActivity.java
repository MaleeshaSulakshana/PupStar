package com.example.pupstar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

public class DiseasePrescriptionsActivity extends AppCompatActivity {

    private TextView desc;
    private CardView btnNext;

    private String details = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_prescriptions);

        desc = (TextView) this.findViewById(R.id.desc);
        btnNext = (CardView) this.findViewById(R.id.btnNext);

        details = "..................................................";
        desc.setText(details);

    }
}