package com.example.timetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/* 
This class implements the second portion of the app description.
As with part 1, waits unlick user decides to proceed forwared
*/
public class AppDescript2 extends AppCompatActivity {
    Button descript2Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_descript2);
        //descript2button is the "NEXT" button
        descript2Button = findViewById(R.id.descript2_button);
        descript2Button.setOnClickListener(new View.OnClickListener() {
        //when "NEXT" button is clicked, start the next intent, which is the "Select categories" page
        public void onClick(View view){
            Intent intent = new Intent(AppDescript2.this,SelectCategories.class);
            startActivity(intent);
        }
        });
    }
}
