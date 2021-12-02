package com.example.uiassignment;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uiassignment.databinding.ActivityMainBinding;

import java.io.InputStream;

public class MainActivity extends Activity {
    Button stopWatch,background;
    String imagePath;
    DigitalClock digitalClock;
    AnalogClock analogClock;
    Boolean hidden = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stopWatch = findViewById(R.id.stopWatch2);
        background = findViewById(R.id.background);
        digitalClock=findViewById(R.id.digitalClock);
        analogClock=findViewById(R.id.analogClock);
        //startActivity(new Intent(MainActivity.this,StopWatch.class));
        stopWatch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(MainActivity.this, StopWatch.class));
            }
        });
        background.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(hidden){
                    analogClock.setVisibility(View.INVISIBLE);
                    digitalClock.setVisibility(View.VISIBLE);
                    hidden=false;
                }else{
                    analogClock.setVisibility(View.VISIBLE);
                    digitalClock.setVisibility(View.INVISIBLE);
                    hidden=true;
                }
            }
        });

    }
    public void onClockClick(){
        startActivity(new Intent(MainActivity.this,WatchFace.class));
    }
    private String getPathFromUri(Uri contentUri) {
        String filePath;
        Cursor cursor = getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            filePath = contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex("_data");
            filePath = cursor.getString(index);
            cursor.close();
        }
        return filePath;
    }
}