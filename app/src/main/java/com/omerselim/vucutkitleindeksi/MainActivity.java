package com.omerselim.vucutkitleindeksi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Double.valueOf;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    EditText textEnter;
    EditText textEnter2;
    Spinner spinner;
    double boy,kilo;
    double vki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textEnter = findViewById(R.id.textEnter);
        textEnter2 = findViewById(R.id.textEnter2);
        spinner = findViewById(R.id.spinner);

        spinner();


    }
    public void hesapla(View view)  {
        if(textEnter.getText().toString().matches("") || textEnter2.getText().toString().matches(""))    {
            Toast.makeText(MainActivity.this,"Lütfen bir SAYI giriniz",Toast.LENGTH_LONG).show();
        }
        else {
            boy = parseDouble(textEnter.getText().toString());
            kilo = parseDouble(textEnter2.getText().toString());


            if (boy >= 100 && boy <= 220 && kilo >= 45 && kilo <= 200) {

                vki = kilo / ((boy / 100) * (boy / 100));


                textView.setText(String.format("Vücut kitle indeksiniz: %.2f", vki));

                if (vki < 18.5) {
                    textView2.setText("Sonuc: Düşük Kilolu");
                } else if (vki >= 18.5 && vki < 25) {
                    textView2.setText("Sonuç: Normal Kilolu");
                } else if (vki >= 25 && vki < 30) {
                    textView2.setText("Sonuç: Fazla Kilolu");
                } else if (vki >= 30 && vki < 40) {
                    textView2.setText("Sonuç: Obez");
                } else {
                    textView2.setText("Sonuç: Aşırı Obez");
                }
            } else {
                Toast.makeText(MainActivity.this, "Geçerli sayılar giriniz.", Toast.LENGTH_LONG).show();
                textView.setText("Vücut kitle indeksiniz: ");
                textView2.setText("Sonuç: ");
                textEnter.getText().clear();
                textEnter2.getText().clear();
            }
        }
    }
    public void spinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.choices));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 1:
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

}