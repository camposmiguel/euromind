package com.miguelcr.listviewcustom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    ArrayList<FruitItem> fruitItems;

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
        lista = (ListView)findViewById(R.id.listView);

        // Fruits
        FruitItem banana = new FruitItem(R.drawable.ic_banana,"Banana");
        FruitItem strawberry = new FruitItem(R.drawable.ic_strawberry,"Strawberry");
        FruitItem peach = new FruitItem(R.drawable.ic_peach,"Peach");
        FruitItem kiwi = new FruitItem(R.drawable.ic_kiwi,"Kiwi");
        FruitItem lemon = new FruitItem(R.drawable.ic_lemon,"Lemon");
        FruitItem mango = new FruitItem(R.drawable.ic_mango,"Mango");
        FruitItem orange = new FruitItem(R.drawable.ic_orange,"Orange");

        // Create an array and add fruits to the array
        fruitItems = new ArrayList<FruitItem>();
        fruitItems.add(banana);
        fruitItems.add(strawberry);
        fruitItems.add(peach);
        fruitItems.add(kiwi);
        fruitItems.add(lemon);
        fruitItems.add(mango);
        fruitItems.add(orange);

        // The next lines of code help us to adapt de fruitItems
        // to our custom design defined in the layout fruit_list_item.xml
        FruitAdapter adapter = new FruitAdapter(this,fruitItems);
        lista.setAdapter(adapter);


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
