package com.example.contractplayfinal;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tipotramite extends AppCompatActivity  {
    EditText textBox;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tramite);
        textBox = (EditText) findViewById(R.id.txtText1);
    }
    public void onClickSave(View view) {
        String str = textBox.getText().toString();
        try
        {
            // Almacenamiento Interno
            FileOutputStream fOut=openFileOutput("textfile.txt",
                    Context.MODE_PRIVATE);
            try {
                fOut.write(str.getBytes());
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fOut.close();
            }
            //---Muestra el mensaje almacenado---
            Toast.makeText(getBaseContext(),"Tramite grabado satisfactoriamente!", Toast.LENGTH_SHORT).show();
            textBox.setText("");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}