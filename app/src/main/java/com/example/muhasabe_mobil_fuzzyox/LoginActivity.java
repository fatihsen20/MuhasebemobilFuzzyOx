package com.example.muhasabe_mobil_fuzzyox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth ;
    private FirebaseUser mUser;
    private FirebaseFirestore firestore;
    private EditText e_mail, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e_mail = findViewById(R.id.activity_login_Email);
        pass = findViewById(R.id.activity_login_Pass);


    }

    public void newLogin(View view){
        String txtEmail, txtPass;
        txtEmail = e_mail.getText().toString();
        txtPass = pass.getText().toString();

        if (!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPass)){

            DBHandler dbHandler = new DBHandler(mAuth, mUser, firestore);
            dbHandler.addLogin(txtEmail, txtPass, this);

        }
        else
            Toast.makeText(this, "Lütfen Girdileri Boş Bırakmayın!", Toast.LENGTH_SHORT).show();
    }
}