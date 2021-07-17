package com.example.muhasabe_mobil_fuzzyox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainMenu extends AppCompatActivity {

    private DBHandler dbHandler;
    private FirebaseAuth mAuth;
    Intent intent;
    private FirebaseFirestore firestore;
    private GridView gridView ;
    private String[] items = {"Kişisel Bilgiler","deneme2", "deneme3", "deneme4", "deneme5", "deneme6",};
    private int[] icons = {R.drawable.common_google_signin_btn_icon_dark_normal , R.drawable.common_google_signin_btn_icon_dark,R.drawable.common_google_signin_btn_icon_dark_normal,R.drawable.common_google_signin_btn_icon_dark_normal,R.drawable.common_google_signin_btn_icon_dark_normal,R.drawable.common_google_signin_btn_icon_dark_normal};
    private MainMenuAdapter mainMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        dbHandler = new DBHandler(mAuth, firestore);

        gridView = findViewById(R.id.activity_main_menu_gridItems);
        mainMenuAdapter = new MainMenuAdapter(items , icons , MainMenu.this);
        gridView.setAdapter(mainMenuAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (items[position].compareTo("Kişisel Bilgiler") == 0){

                    intent = getIntent();
                    dbHandler.getData(MainMenu.this,intent.getStringExtra("uId"));

                }
                Toast.makeText(MainMenu.this, items[position], Toast.LENGTH_SHORT).show();
            }
        });

        Animations.addAnimation(this , R.id.activity_main_menu_gridItems, R.anim.bounce, 1000);
    }
}