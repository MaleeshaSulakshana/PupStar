package com.example.pupstar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DiseaseDetectionDashboardActivity extends AppCompatActivity {

    private Button btnDetect, btnPreRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_detection_dashboard);

        btnDetect = (Button) this.findViewById(R.id.btnDetect);
        btnPreRecords = (Button) this.findViewById(R.id.btnPreRecords);

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiseaseDetectionDashboardActivity.this, DetectDiseaseActivity.class);
                startActivity(intent);
            }
        });

        btnPreRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiseaseDetectionDashboardActivity.this, PreviousDiseasesActivity.class);
                startActivity(intent);
            }
        });

    }
}