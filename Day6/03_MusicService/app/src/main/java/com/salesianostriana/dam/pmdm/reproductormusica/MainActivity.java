package com.salesianostriana.dam.pmdm.reproductormusica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    String nombreCancionSeleccionada;
    ToggleButton btnPlay;
    RadioButton radioButton;
    int uriCancion = R.raw.michael_buble;
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences("PLAYER_DATA", 0);
        editor = settings.edit();

        btnPlay = (ToggleButton) findViewById(R.id.toggleButtonPlay);

        boolean state = settings.getBoolean("isPlay", false);
        btnPlay.setChecked(state);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!btnPlay.isChecked()) {
                    Intent i = new Intent(MainActivity.this,MusicService.class);
                    stopService(i);

                    // SAVE THE STATE OF THE PLAYER
                    editor.putBoolean("isPlay", false);
                    editor.commit();
                } else {
                    Intent i = new Intent(MainActivity.this, MusicService.class);
                    i.putExtra("song", "Sam Smith");
                    i.putExtra("path", R.raw.sam_smith);
                    startService(i);

                    // SAVE THE STATE OF THE PLAYER
                    editor.putBoolean("isPlay", true);
                    editor.commit();

                }
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Intent i = new Intent(MainActivity.this,MusicService.class);
        stopService(i);

    }
}
