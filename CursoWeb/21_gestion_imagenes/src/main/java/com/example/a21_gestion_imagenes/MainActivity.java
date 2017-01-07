package com.example.a21_gestion_imagenes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnChange;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange = (Button) findViewById(R.id.btnchange);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        btnChange.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        imageView2.setImageResource(R.mipmap.ic_launcher);
    }
}
