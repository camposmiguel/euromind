package com.miguelcr.relativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name, surname;
    TextView userName, userSurname;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve de reference of the component
        name = (EditText) findViewById(R.id.editTextName);
        surname = (EditText) findViewById(R.id.editTextSurname);
        userName = (TextView) findViewById(R.id.textViewName);
        userSurname = (TextView) findViewById(R.id.textViewSurname);
        btn = (Button) findViewById(R.id.buttonSendTwo);

        // Declare the click event
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textName = name.getText().toString();
                String surnameText = surname.getText().toString();

                userName.setText(textName);
                userSurname.setText(surnameText);
            }
        });
    }

    public void sendDataUser(View view) {
        String textName = name.getText().toString();
        String surnameText = surname.getText().toString();

        userName.setText(textName);
        userSurname.setText(surnameText);
    }
}
