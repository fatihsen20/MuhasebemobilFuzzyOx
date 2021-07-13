package com.example.muhasabe_mobil_fuzzyox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth ;
    private FirebaseUser mUser;
    private FirebaseFirestore firestore;
    private EditText name, surname, e_mail, pass, pass_validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.activity_register_name);
        surname = findViewById(R.id.activity_register_surname);
        e_mail = findViewById(R.id.activity_register_Email);
        pass = findViewById(R.id.activity_register_Pass);
        pass_validation = findViewById(R.id.activity_register_Pass_validation);

    }

    public void newRegister(View view){

        String txtName = name.getText().toString();
        String txtSurname = surname.getText().toString();
        String txtEmail = e_mail.getText().toString();
        String txtPass = pass.getText().toString();
        String txtPass_validation = pass_validation.getText().toString();

        if (!TextUtils.isEmpty(txtName) && !TextUtils.isEmpty(txtSurname) && !TextUtils.isEmpty(txtEmail)
                && !TextUtils.isEmpty(txtPass) && !TextUtils.isEmpty(txtPass_validation)){ //Girdilerin boşluk kontrolü

            if (txtPass.compareTo(txtPass_validation) !=0) // Şifre doğruluğu
                Toast.makeText(this, "Lütfen şifreleri aynı giriniz!", Toast.LENGTH_SHORT).show();
            else{
                User user = new User(txtName,txtSurname,txtEmail,txtPass);
                DBHandler dbHandler = new DBHandler(mAuth, mUser, firestore);
                dbHandler.addRegister(user, RegisterActivity.this);
            }
        }
        else
            Toast.makeText(this, "Girdiler Boş Olamaz!", Toast.LENGTH_SHORT).show();
    }


}