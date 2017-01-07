package com.example.a20_objectos_bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etNombre,etPswd;
    private Button btnIngresar,btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etPswd = (EditText) findViewById(R.id.etPswd);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        btnIngresar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
    }


    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()){
            case R.id.btnIngresar:
                String  nombre = etNombre.getText().toString();
                String pswd = etPswd.getText().toString();
                if (nombre.equals("Salvador") && pswd.equals("123")){
                    //Mostrar por pantalla
                    Intent int1 = new Intent("com.example.a19_intents.Actividad2");
                    Bundle bolsa = new Bundle();
                    bolsa.putString("nombrekey", nombre);
                    int1.putExtras(bolsa);
                    startActivity(int1);
                }
                else {
                    Toast t=Toast.makeText(this,"Error intentalo de nuevo",Toast.LENGTH_SHORT);
                    t.show();
                }
                break;
            case R.id.btnBorrar:
                etNombre.setText("");
                etPswd.setText("");
                break;
        }

    }
}
