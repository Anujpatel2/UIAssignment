package com.example.uiassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uiassignment.databinding.ActivityMainBinding;

public class WatchFace extends Activity {
    private TextView mTextView;
    private ActivityMainBinding binding;
    Button stopWatch,alarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_face);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        stopWatch=findViewById(R.id.stopWatch2);
        alarm=findViewById(R.id.alarm);

        stopWatch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(WatchFace.this,StopWatch.class));
            }
        });
    }
}