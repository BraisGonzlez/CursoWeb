package com.example.a20_objectos_bundle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by brais on 07/01/2017.
 */

public class Actividad2 extends Activity {

    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        //Creo un objeto Bundle, y hago un obtener datos
        Bundle bolsaR = getIntent().getExtras();
        tvUsername.setText(bolsaR.getString("nombreKey"));

    }
}