package com.example.brais.channelband;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.brais.channelband.Database.DBUsers;

import java.util.ArrayList;

/**
 * Created by brais on 27/01/2017.
 */

public class Components extends AppCompatActivity {

    ListView lv;
    DBUsers mydb;
    ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.components);
        load();
    }

    public void load() {

        mydb = new DBUsers(this);
        Cursor res = mydb.getAllData();

        if (res.getCount() == 0) {
            // show message
            showMessage("Error", "Nothing found");
            return;
        }
        else {
            int total = res.getCount();
            String [] array = new String[total];
            int i = 0;
            while (res.moveToNext()) {
                String data = "Name: " + res.getString(0)+"\n"+"Instrument: "+res.getString(1)+"\n"+"Band: " + res.getString(2)+"\n"
                        +"Old Band: " + res.getString(3)+"\n";
                array[i]= data;
                i++;
            }
            ListAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
            lv = (ListView) findViewById(R.id.listView);
            lv.setAdapter(adaptador);
        }
    }

    /**********************************************************************************************/
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
