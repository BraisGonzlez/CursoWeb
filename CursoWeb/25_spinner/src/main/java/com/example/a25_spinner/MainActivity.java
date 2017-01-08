package com.example.a25_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Spinner spMarca,spModelo;
    ArrayAdapter<String> aaMarca,aaModelo,aaClear;
    String [] opcMarca = new String[]{"HTC","Samsung","LG","Sony"};
    String [] opcModelo = new String[]{"W100","W200","W300","Xperia"};
    String [] opcClear = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMarca = (Spinner) findViewById(R.id.spMarca);
        spModelo = (Spinner) findViewById(R.id.spModelo);

        spMarca.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        spModelo.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        aaMarca = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcMarca);
        aaModelo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcModelo);
        aaClear = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcClear);

        spMarca.setAdapter(aaMarca);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        switch (arg0.getId()){
        case R.id.spMarca:
            int seleccionado = spMarca.getSelectedItemPosition();
            if(seleccionado == 3)
                spModelo.setAdapter(aaModelo);
            else
                spModelo.setAdapter(aaClear);
        }
    }
}
