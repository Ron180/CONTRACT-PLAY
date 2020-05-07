package com.example.contractplayfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrate1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate1);
    }
    public void registroExistoso(View view){
        Toast.makeText(this, "Se ah regristrado \n correctamente", Toast.LENGTH_LONG).show();
    }
}
