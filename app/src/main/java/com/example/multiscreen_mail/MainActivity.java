package com.example.multiscreen_mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        generateEvents();
    }

    private void initialization() {
        ClickMe=findViewById(R.id.ClickMe);
    }

    private void generateEvents() {
        ClickMe.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent SecondActivity = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(SecondActivity);


    }
}