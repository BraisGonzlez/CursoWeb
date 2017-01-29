package com.example.brais.channelband.StaticFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.brais.channelband.R;

public class Main_Fragments extends AppCompatActivity implements View.OnClickListener {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);

        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent  x = new Intent("com.example.brais.channelband.StaticFragments.Second_Activity");
        startActivity(x);
    }
}

