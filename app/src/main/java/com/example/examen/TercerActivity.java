package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class TercerActivity extends AppCompatActivity {

    String nombre= "";
    TextView texto;
    ImageButton btnIm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
        texto= findViewById(R.id.textView);
        btnIm= findViewById(R.id.btnIma);

        btnIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if(savedInstanceState==null){
            Bundle extras=getIntent().getExtras();
            if(extras==null){
                nombre=null;
            }else{
                nombre=extras.getString("nombre");
                texto.setText(nombre);
            }
        }else{
            //validar diferentes formas de commo podemos recibir el parametro que nos estan enviando
            nombre=(String)savedInstanceState.getSerializable("nombre");
        }

    }
}