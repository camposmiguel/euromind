package com.miguelcr.calculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btnAdd, btnEq;
    TextView screen;
    float num1=0, num2=0;
    String operator = "";
    boolean firstChar = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);
        Typeface fontDigital = Typeface.createFromAsset(getAssets(),"digital.ttf");
        screen.setTypeface(fontDigital);

        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnEq = (Button)findViewById(R.id.buttonEqual);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnEq.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(firstChar) {
            firstChar = false;
            screen.setText("");
        }

        switch (v.getId()) {
            case R.id.button1:
                screen.setText(screen.getText()+"1");
                break;
            case R.id.button2:
                screen.setText(screen.getText()+"2");
                break;
            case R.id.button3:
                screen.setText(screen.getText()+"3");
                break;
            case R.id.buttonAdd:
                num1 = Float.valueOf(screen.getText().toString());
                operator = "+";
                screen.setText("");
                break;
            case R.id.buttonEqual:
                num2 = Float.valueOf(screen.getText().toString());
                if(operator.equals("+")){
                    screen.setText(String.valueOf(num1+num2));
                    Log.i("RES","RES: "+String.valueOf(num1+num2));
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.clear_calc:
                //TODO the action of clear calc
                Toast.makeText(this,"Click on clear button",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
