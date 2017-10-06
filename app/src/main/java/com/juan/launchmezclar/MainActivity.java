package com.juan.launchmezclar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

//Notas del 6 oct 2017
//Ver como limitar la entrada a 16 digitos
//commit 4321

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                sendIntentToAppMezclar();
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

    public void sendIntentToAppMezclar(){
        //declaro el edittext
        EditText secuenciaDeImagenes   = (EditText)findViewById(R.id.secImagenes);
        //Especifico el paquete que quiero lanzar, la app Mezclar
        Intent launchMezclarApplication = getPackageManager().getLaunchIntentForPackage("com.juan.mezclar");
        //launchMezclarApplication.putExtra("KeyName","Hola, te estoy llamando");
        launchMezclarApplication.putExtra("KeyName", secuenciaDeImagenes.getText().toString() );

        startActivity(launchMezclarApplication);
    }
}
