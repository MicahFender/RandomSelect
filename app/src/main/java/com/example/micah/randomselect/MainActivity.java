package com.example.micah.randomselect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView tvOutput = (TextView) findViewById(R.id.tvOutput);  //Sets reference to output text field
        tvOutput.setText(""); //Changes the output text to empty for the initial run of app.

        Button btnPickRandom =(Button) findViewById(R.id.btnPickRandom);
        Button btnMap = (Button) findViewById(R.id.btnMap);

        btnPickRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = Data.getLength();
                if (length <= 0){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Unable to find any data.  Please try again later.");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Okay",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else {
                int selection = -1; //Initializes the selection variable to prime the error check loop below.
                while (selection < 0 || selection > Data.getLength()) {

                    selection = (int)(Math.random() * Data.getLength());  //Data.getLength will return a number >= 1 if there are items in the list which is zero indexed, so only simple multiplication is needed.
                }
                tvOutput.setText(Data.getData(selection));
            }}
        });

        btnMap.setOnClickListener(new View.OnClickListener() {

            @Override
        public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
