package com.example.currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double euroCost = .90160;
    double pesoCost = 19.4055;
    double canCost = 1.32865;
    double numEntered;
    double fx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_photo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText usd = (EditText) findViewById(R.id.dollars);
        final RadioButton radio1 = (RadioButton) findViewById(R.id.btn1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.btn2);
        final RadioButton radio3 = (RadioButton) findViewById(R.id.btn3);
        Button cost = (Button)findViewById(R.id.btnConvert);
        cost.setOnClickListener(new View.OnClickListener(){
            final TextView finalResult = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {
                numEntered = Integer.parseInt(usd.getText().toString());
                DecimalFormat currency = new DecimalFormat("###,###.##");
                if (numEntered < 10000) {
                    if (radio1.isChecked()) {
                        fx = euroCost * numEntered;
                        finalResult.setText("Euros are $" + currency.format(fx));
                    } else if (radio2.isChecked()) {
                        fx = pesoCost * numEntered;
                        finalResult.setText("Mexican Pesos are $" + currency.format(fx));
                    } else {
                        fx = canCost * numEntered;
                        finalResult.setText("Canadian dollars are $" + currency.format(fx));
                    }
                }else{
                    finalResult.setText("Max USD to convert is $10,000");

                }
            }
        });

    }
}
