package com.example.pupstar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DogsBehaviorDashboardActivity extends AppCompatActivity {

    private Button btnBehavior, btnPreRecords, btnTimeSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs_behavior_dashboard);

        btnBehavior = (Button) this.findViewById(R.id.btnBehavior);
        btnPreRecords = (Button) this.findViewById(R.id.btnPreRecords);
        btnTimeSchedule = (Button) this.findViewById(R.id.btnTimeSchedule);

        btnBehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DogsBehaviorDashboardActivity.this, DetectBehaviorActivity.class);
                startActivity(intent);

            }
        });

    }
}