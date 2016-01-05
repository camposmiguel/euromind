package com.miguelcr.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        String userEmail = extras.getString("email");
        String userPass = extras.getString("password");

        textViewEmail = (TextView)findViewById(R.id.textView);
        textViewEmail.setText(userEmail);

        textViewEmail = (TextView)findViewById(R.id.textView2);
        textViewEmail.setText(userPass);


    }
}
