package com.example.contractplayfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MENU extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClick3(View view){

        startActivity(new Intent("com.example.CONTRATOgeneral"));
    }
    public void onClick4(View view){

        startActivity(new Intent("com.example.BUFFETDEabogados"));
    }
    public void onClick5(View view){

        startActivity(new Intent("com.example.TUTORIALES"));
    }

}
