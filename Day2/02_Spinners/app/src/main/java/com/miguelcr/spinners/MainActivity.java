package com.miguelcr.spinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    Spinner lista;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (Spinner)findViewById(R.id.planets_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        lista.setAdapter(adapter);

        lista.setSelection(2);
        lista.setOnItemSelectedListener(this);


        // Button click
        btn = (Button)findViewById(R.id.buttonClick);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Click on Button event
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String planet = (String)parent.getItemAtPosition(position);
        Toast.makeText(this,"Planet: "+planet,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
