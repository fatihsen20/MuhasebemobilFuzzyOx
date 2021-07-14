package com.example.muhasabe_mobil_fuzzyox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPass extends AppCompatActivity {

    private FirebaseAuth mAuth;
    DBHandler dbHandler;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        email = findViewById(R.id.activity_forgot_pass_email);
        dbHandler = new DBHandler(mAuth);

        Animations.addAnimation(this, R.id.activity_forgot_pass_email, R.anim.fadein , 1000);
        Animations.addAnimation(this, R.id.activity_forgot_pass_btnResetpass, R.anim.bounce , 1000);
    }

    public void ResetPass(View view){

        if (!TextUtils.isEmpty(email.getText().toString())){

            dbHandler.resetPass(email.getText().toString() , this);

        }
        else
            Toast.makeText(this, "Lütfen Kutucuğu Boş Bırakmayın!", Toast.LENGTH_SHORT).show();
    }
}