package com.ketra.carometric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;

public class DisplayActivity extends AppCompatActivity {
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        test = findViewById(R.id.testId);

        // Get the intent to extract relevant message from starting activity
        Intent intent = getIntent();

        // Extract passed extras from the intent
        Bundle extras = intent.getExtras();

        HashMap<String, Object> jsonMap = new HashMap<String, Object>();

        //Verify it is not empty and display the data
        if(!extras.isEmpty()) {
            jsonMap = (HashMap<String, Object>)intent.getSerializableExtra("map");
//            test.setText(extras.getString("data"));
        }
    }

}
