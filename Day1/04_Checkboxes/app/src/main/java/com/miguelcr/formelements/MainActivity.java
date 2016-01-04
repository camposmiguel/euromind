package com.miguelcr.formelements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.buttonSend);
        sex = (RadioGroup)findViewById(R.id.sex);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idSelectedSex = sex.getCheckedRadioButtonId();
                RadioButton sexSelected = (RadioButton)findViewById(idSelectedSex);
                Toast.makeText(MainActivity.this,"Sex: "+sexSelected.getText(),Toast.LENGTH_SHORT)
                        .show();

            }
        });
    }

    public void payMoney(View view) {
        CheckBox myCheckbox = (CheckBox)view;
        boolean checked = myCheckbox.isChecked();

        if(checked) {
            Toast.makeText(this, "Thank you for the money!",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Try to say me tomorrow!",Toast.LENGTH_LONG).show();
        }

    }
}
