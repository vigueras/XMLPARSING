package com.example.guadalupe.xmlparsing;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Vista_Indiv extends Activity {
    static final String KEY_ID_PLANTA = "id_planta";
    static final String KEY_NOMBRE_PLANTA = "nombre_planta";
    static final String KEY_TIPO_PLANTA= "tipo_planta";
    static final String KEY_COLOR_PLANTA = "color_planta";
    static final String KEY_PRECIO = "precio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__indiv);

        Intent in = getIntent();

        // Get XML values from previous intent
        String id_pla = in.getStringExtra(KEY_ID_PLANTA);
        String nombre_plan = in.getStringExtra(KEY_NOMBRE_PLANTA);
        String tipo_plan= in.getStringExtra(KEY_TIPO_PLANTA);
        String color_plan= in.getStringExtra(KEY_COLOR_PLANTA);
        String prec= in.getStringExtra(KEY_PRECIO);



        // Displaying all values on the screen
        TextView lbl_id = (TextView) findViewById(R.id.id_pla);
        TextView lblnombre = (TextView) findViewById(R.id.nombre_plan);
        TextView lbltipo = (TextView) findViewById(R.id.tipo_plan);
        TextView lblcolor = (TextView) findViewById(R.id.color_plan);
        TextView lblpre = (TextView) findViewById(R.id.preci);

        lbl_id.setText(id_pla);
        lblnombre.setText(nombre_plan);
        lbltipo.setText(tipo_plan);
        lblcolor.setText(color_plan);
        lblpre.setText(prec);


    }


}
