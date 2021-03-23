package com.omerselim.vucutkitleindeksi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    RadioButton radioButton;
    RadioButton radioButton2;
    EditText textEnter;
    EditText textEnter2;
    EditText textEnter3;
    Button button;
    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = findViewById(R.id.spinner);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        Button button;
        textEnter = findViewById(R.id.textEnter);
        textEnter2 = findViewById(R.id.textEnter2);
        textEnter3 = findViewById(R.id.textEnter3);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        spinner();
    }

    public void spinner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity2.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.choices));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            switch (i) {
                case 2:
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);

                    startActivity(intent);
                    break;
            }
        }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}