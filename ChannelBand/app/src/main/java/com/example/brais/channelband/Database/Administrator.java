package com.example.brais.channelband.Database;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brais.channelband.R;

/**
 * Created by braisgi@gmail.com
 */

public class Administrator extends AppCompatActivity {

    DBUsers myDb;
    EditText et_name, et_instrument, et_band, et_oldband;
    Button btnAddData, btnDelete, btnviewAll, btnviewUpdate;

    /**********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administrator);
        myDb = new DBUsers(this);

        et_name = (EditText) findViewById(R.id.et_name);
        et_instrument = (EditText) findViewById(R.id.et_instrument);
        et_band = (EditText) findViewById(R.id.et_band);
        et_oldband = (EditText) findViewById(R.id.et_oldband);

        btnAddData = (Button) findViewById(R.id.btnAddData);
        btnviewAll = (Button) findViewById(R.id.btnviewAll);
        btnviewUpdate = (Button) findViewById(R.id.btnviewUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();

    }

    /**********************************************************************************************/
    public void AddData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String instrument = et_instrument.getText().toString();
                String band = et_band.getText().toString();
                String oldband = et_oldband.getText().toString();

                boolean isInserted = myDb.insertData(name,instrument,band,oldband);

                if (isInserted)
                    Toast.makeText(Administrator.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Administrator.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**********************************************************************************************/
    public void DeleteData() {

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(et_name.getText().toString());
                if (deletedRows > 0)
                    Toast.makeText(Administrator.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Administrator.this, "Data not Deleted", Toast.LENGTH_LONG).show();
            }
        }
        );
    }

    /**********************************************************************************************/
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(et_name.getText().toString(), et_instrument.getText().toString(),
                        et_band.getText().toString(), et_oldband.getText().toString());
                if (isUpdate)
                    Toast.makeText(Administrator.this, "Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Administrator.this, "Data not Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**********************************************************************************************/
    public void viewAll() {
        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("Name :").append(res.getString(0)).append("\n");
                    buffer.append("Instrument :").append(res.getString(1)).append("\n");
                    buffer.append("Band :").append(res.getString(2)).append("\n");
                    buffer.append("Old Band :").append(res.getString(3)).append("\n\n");
                }
                // Show all data
                showMessage("Data", buffer.toString());
            }
        });
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