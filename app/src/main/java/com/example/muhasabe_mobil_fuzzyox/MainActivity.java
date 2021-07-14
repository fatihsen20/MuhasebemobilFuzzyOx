package com.example.muhasabe_mobil_fuzzyox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animations.addAnimation(this, R.id.activity_main_btnLogin, R.anim.lefttoright , 1000);
        Animations.addAnimation(this , R.id.activity_main_btnRegister , R.anim.righttoleft , 1000);
        Animations.addAnimation(this , R.id.activity_main_myLogo , R.anim.fadein ,1000 );
        Animations.addAnimation(this , R.id.activity_main_txtViewWelcome, R.anim.fadein , 1000);

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