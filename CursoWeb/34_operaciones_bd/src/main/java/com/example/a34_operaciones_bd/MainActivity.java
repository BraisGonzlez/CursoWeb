package com.example.a34_operaciones_bd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        btn_agregar.setOnClickListener(this);
        btn_mostrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()){
            case R.id.btn_agregar:
                String numero=etTel.getText().toString();

                try{
                    BDhelper bda = new BDhelper(this);
                    bda.abrir();
                    long result = bda.registrar(numero);
                    bda.cerrar();
                    System.out.println("EOOOOOOOOOOO");
                    if (result>0){
                        Toast t = Toast.makeText(this,"Valor insertado con éxito",Toast.LENGTH_LONG);
                        t.show();
                    }
                }
                catch (Exception e) {
                    Toast t = Toast.makeText(this,e.toString(),Toast.LENGTH_LONG);
                    t.show();
                }
                break;

        }
    }
}
