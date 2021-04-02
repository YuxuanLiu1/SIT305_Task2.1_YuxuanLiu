package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] unit =  {"Metre","Celsius","Kilogram"};
    EditText input;
    TextView output1;
    TextView output2;
    TextView output3;
    ImageView metre;
    ImageView kilogram;
    ImageView celsius;
    Spinner Spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.userinput);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);

        metre = findViewById(R.id.metreicon);
        kilogram = findViewById(R.id.kilogramicon);
        celsius = findViewById(R.id.celsiusicon);
        Spinner1 = findViewById(R.id.spinner);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,unit);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        metre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Spinner1.getSelectedItem().toString();
                if (text.equals("Metre")) {

                    double n1 = Integer.parseInt(String.valueOf(input.getText()));
                    output1.setText(String.format("%.2f", n1*100)+" Centimetre");
                    output2.setText(String.format("%.2f", n1*3.28)+" Foot");
                    output3.setText(String.format("%.2f", n1*39.37)+" inch");
                } else {
                    output1.setText("Error");
                    output2.setText("Please select right unit");
                    output3.setText("");
                }
            }

        });

        kilogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Spinner1.getSelectedItem().toString();
                if (text.equals("Kilogram")) {

                    double n1 = Integer.parseInt(String.valueOf(input.getText()));
                    output1.setText(String.format("%.2f", n1/100)+" Gram");
                    output2.setText(String.format("%.2f", n1*35.27)+" Ounce(Oz)");
                    output3.setText(String.format("%.2f", n1*2.2)+" Pound(lb)");
                } else {
                    output1.setText("Error");
                    output2.setText("Please select right unit");
                    output3.setText("");
                }
            }

        });

        celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Spinner1.getSelectedItem().toString();
                if (text.equals("Celsius")) {

                    double n1 = Integer.parseInt(String.valueOf(input.getText()));
                    output1.setText(String.format("%.2f", n1 * 9 / 5 + 32)+" Fahrenheit");
                    output2.setText(String.format("%.2f", n1+273.15)+" Kelvin");
                    output3.setText("");
                } else {
                    output1.setText("Error");
                    output2.setText("Please select right unit");
                    output3.setText("");

                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
