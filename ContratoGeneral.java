package com.example.contractplayfinal;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contractplayfinal.db_firebase.Clases;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContratoGeneraL extends AppCompatActivity{
    private DatabaseReference Clases;
    EditText txtTema;
    Spinner spinNotaria, spinarea;
    Button btnRegistrar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato);
        Clases = FirebaseDatabase.getInstance().getReference("Clases");
        txtTema = (EditText)findViewById(R.id.txttema);
        spinNotaria = (Spinner)findViewById(R.id.spinnotaria);
        spinarea = (Spinner)findViewById(R.id.spinarea);
        btnRegistrar = (Button)findViewById(R.id.btnregistrar);
        btnRegistrar = (Button)findViewById(R.id.btnregistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                registrarClase();
            }
        });
    }
    public void registrarClase(){
        String seccion =spinNotaria.getSelectedItem().toString();
        String area = spinarea.getSelectedItem().toString();
        String tema = txtTema.getText().toString();
        if(!TextUtils.isEmpty(tema)){
            String id = Clases.push().getKey();
            Clases leccion = new Clases(id, seccion, area, tema);
            Clases.child("Contratos").child(id).setValue(leccion);
            Toast.makeText(this, "Contrato registrado", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this,"Debe introducir un tema",
                    Toast.LENGTH_LONG).show();
        }
    }
    public void onClickcont1(){
        startActivity(new Intent("com.example.CONTRATO1"));
    }
}
