package com.project.visiti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;


import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

public class ChooseCityActivity extends AppCompatActivity {
    ImageButton previousScreen;
    ImageButton nextScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);
        previousScreen = (ImageButton)findViewById(R.id.previousScreen);
        nextScreen = (ImageButton)findViewById(R.id.nextScreen);

        SearchableSpinner searchableSpinner = (SearchableSpinner) findViewById(R.id.searchable_spinner);
        String[] items = new String[] { "Lviv", "London", "Kyiv", "New York", "Paris"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.choose_city_item_style, R.id.item ,items);
        adapter.setDropDownViewResource(R.layout.choose_city_item_style);
        searchableSpinner.setPositiveButton("Cancel");
        searchableSpinner.setAdapter(adapter);
    }

    public void PreviousScreen(View view) {
        Intent smth = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(smth);
    }

    public void NextScreen(View view) {
        Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show();
    }
}
