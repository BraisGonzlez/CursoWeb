package com.example.a32_introduccion_sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etTel;
    Button btn_agregar,btn_mostrar;
    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTel = (EditText) findViewById(R.id.etTel);
        btn_agregar = (Button) findViewById(R.id.btn_agregar);
        btn_mostrar = (Button) findViewById(R.id.btn_mostrar);
        tvDatos = (TextView) findViewById(R.id.tvDatos);
    }
}
