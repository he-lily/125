package com.example.timetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//the corresponding activity is the "creating your personalized screen usage plan" page
public class GeneratingPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generating_plan);
        //button2 is "I'm ready" button
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            //on click, move to next page
            public void onClick(View view){
                Intent intent = new Intent(GeneratingPlan.this, BottomNavView.class);
                startActivity(intent);
               
            }
        });
    }
}

