package com.example.brais.channelband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by braisgi@gmail.com
 */

public class Gallery extends AppCompatActivity {

    ImageView photo1, photo2, photo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        photo1 = (ImageView) findViewById(R.id.photo1);
        photo2 = (ImageView) findViewById(R.id.photo2);
        photo3 = (ImageView) findViewById(R.id.photo3);

        String URL1 = "http://www.orquestasdegalicia.es/img/portada/orquestas/id347portada.jpg";
        String URL2 = "https://i.ytimg.com/vi/b_M783D35Ac/maxresdefault.jpg";
        String URL3 = "https://i.ytimg.com/vi/Jlud9_rwIGg/maxresdefault.jpg";

        //INSERT PICTURES
        Glide.with(this)
                .load(URL1)
                .into(photo1);
        Glide.with(this)
                .load(URL2)
                .into(photo2);
        Glide.with(this)
                .load(URL3)
                .into(photo3);
    }
}
