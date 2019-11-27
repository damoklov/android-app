package com.example.visitiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_city);
        spinner = (Spinner)findViewById(R.id.choose_city_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.listOfCities, R.layout.cities_dropdown_style);
        adapter.setDropDownViewResource(R.layout.cities_dropdown_style);
        spinner.setAdapter(adapter);
    }
}
