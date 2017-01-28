package com.example.brais.channelband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by braisgi@gmail.com
 */

public class History extends AppCompatActivity {

    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        photo = (ImageView) findViewById(R.id.photo);

        String URL = "http://www.orquestasdegalicia.es/img/portada/orquestas/id347portada.jpg";

        //INSERT PICTURES
        Glide.with(this)
                .load(URL)
                .into(photo);
    }
}
