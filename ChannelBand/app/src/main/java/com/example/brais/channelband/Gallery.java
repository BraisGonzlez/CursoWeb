package com.example.brais.channelband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by brais on 19/01/2017.
 */

public class Gallery extends AppCompatActivity {

    private ImageView foto,foto2,foto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        foto = (ImageView) findViewById(R.id.foto);
        foto2 = (ImageView) findViewById(R.id.foto2);
        foto3 = (ImageView) findViewById(R.id.foto3);

        String URL = "http://www.orquestasdegalicia.es/img/portada/orquestas/id347portada.jpg";
        String URL2 = "https://i.ytimg.com/vi/b_M783D35Ac/maxresdefault.jpg";
        String URL3 = "https://i.ytimg.com/vi/Jlud9_rwIGg/maxresdefault.jpg";


        //PARA INSERTAR IMAGENES
        Glide.with(this)
                .load(URL)
                .into(foto);
        Glide.with(this)
                .load(URL2)
                .into(foto2);
        Glide.with(this)
                .load(URL3)
                .into(foto3);
    }
}
