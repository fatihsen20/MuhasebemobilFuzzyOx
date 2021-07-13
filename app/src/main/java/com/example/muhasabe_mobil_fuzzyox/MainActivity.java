package com.example.muhasabe_mobil_fuzzyox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void LoginClick(View view){
        intent = new Intent(MainActivity.this , LoginActivity.class);
        startActivity(intent);
    }
    public void RegisterClick(View view){
        intent = new Intent(MainActivity.this , RegisterActivity.class);
        startActivity(intent);
    }
}