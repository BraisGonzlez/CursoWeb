package com.example.brais.channelband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by brais on 19/01/2017.
 */

public class Gallery extends AppCompatActivity {

    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        foto = (ImageView) findViewById(R.id.foto);
        String URL = "http://www.orquestasdegalicia.es/img/portada/orquestas/id347portada.jpg";
        //PARA INSERTAR IMAGENES
        Glide.with(this)
                .load(URL)
                .into(foto);
    }
}
