package com.example.contractplayfinal;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class BuffetAbogadoS extends AppCompatActivity{
    String[] abogados = { "Claudio and Associates, P.C.","Moore Advocacy Group","Amir Ohebsion, a Professional Corporation","Alcalde Legal","Alan E. Jones, P.C.","Joe M. Hollomon & Associates, P.A.","Law Office of Randy S. Alpert","Axelrod Law Firm","Lutz & Associates, P.S.","Parton & Associates PLLC","Law Offices of Jeffrey I. Amtman","Hernández & Associates, P.C.","Miller, Rosnick, D’Amico, August & Butler, P.C.","Arellano & Phebus S.C.","Penichet & Alberga LLP","Federal Criminal Attorneys of Michigan"," ABAD BOLIVAR","ABAD CASTAÑEDA","ABAD COLAN","ABAD GONZALES","ABAD HEREDIA" }; @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffet);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,abogados);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.txtAbogadoN);
        textView.setThreshold(3);
        textView.setAdapter(adapter);
    }
    public void btnSaludo(View view){
        Toast.makeText(this, "Contactado! \n Le llegara un correo pronto :D", Toast.LENGTH_LONG).show();
    }

}

