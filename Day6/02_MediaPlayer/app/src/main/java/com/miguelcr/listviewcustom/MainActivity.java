package com.miguelcr.listviewcustom;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView lista;
    ArrayList<FruitItem> fruitItems;
    SoundPool soundpool;
    int guitarSound, drummSound, pianoSound;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Get the reference to the listview component
        lista = (GridView) findViewById(R.id.listView);

        // Instruments
        FruitItem drumm = new FruitItem(R.drawable.ic_drumm,"Drumm");
        FruitItem guitar = new FruitItem(R.drawable.ic_guitar,"Guitar");
        FruitItem piano = new FruitItem(R.drawable.ic_piano,"Piano");

        // Create an array and add fruits to the array
        fruitItems = new ArrayList<FruitItem>();
        fruitItems.add(drumm);
        fruitItems.add(guitar);
        fruitItems.add(piano);

        // The next lines of code help us to adapt de fruitItems
        // to our custom design defined in the layout fruit_list_item.xml
        FruitAdapter adapter = new FruitAdapter(this,fruitItems);
        lista.setAdapter(adapter);

        // Player properties
        AudioAttributes aa = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

        soundpool = new SoundPool.Builder()
            .setMaxStreams(10)
            .setAudioAttributes(aa)
            .build();

        // Load sound of guitar
        guitarSound = soundpool.load(this,R.raw.guitar,1);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        soundpool.play(guitarSound,1,1,1,1,1);

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
