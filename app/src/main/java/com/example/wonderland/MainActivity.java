package com.example.wonderland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import interfaces.IBaseContract;
import views.home.HomeActivity;

public class MainActivity extends AppCompatActivity implements IBaseContract.IBaseView {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListener();
    }

    @Override
    public void initViews() {
        btn1 = findViewById(R.id.btn1);
    }

    @Override
    public void setListener() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}