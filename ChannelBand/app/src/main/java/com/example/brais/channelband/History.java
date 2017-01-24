package com.example.brais.channelband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by brais on 12/01/2017.
 */

public class History extends AppCompatActivity {

    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        photo = (ImageView) findViewById(R.id.photo);

        String URL = "http://www.orquestasdegalicia.es/img/portada/orquestas/id347portada.jpg";
        //PARA INSERTAR IMAGENES

        Glide.with(this)
                .load(URL)
                .into(photo);
    }
}
