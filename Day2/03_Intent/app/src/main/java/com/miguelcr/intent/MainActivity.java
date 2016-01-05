package com.miguelcr.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    EditText editTextEmail, editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.buttonNext);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPass = (EditText) findViewById(R.id.editTextPassword);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Launch a new screen: SecondActivity
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("email",editTextEmail.getText().toString());
        i.putExtra("password",editTextPass.getText().toString());
        startActivity(i);
    }
}
