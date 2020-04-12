package com.project.visiti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;

public class AgencyActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    TextInputEditText dateAndTime;
    TextInputEditText hoursOfDate;
    TextInputEditText minutesOfDate;
    int year, month, day, hour, minute;
    int finalYear, finalMonth, finalDay, finalHour, finalMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency);
        dateAndTime = (TextInputEditText)findViewById(R.id.date_and_time_editext);
        hoursOfDate = (TextInputEditText)findViewById(R.id.choose_hours_text);
        minutesOfDate = (TextInputEditText)findViewById(R.id.chose_minutes_text);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        finalYear = year;
        finalMonth = month;
        finalMonth = dayOfMonth;

        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                AgencyActivity.this, AgencyActivity.this, hour, minute, android.text.format.DateFormat.is24HourFormat(AgencyActivity.this)
        );
        timePickerDialog.show();
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, year);
//        c.set(Calendar.MONTH, month);
//        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        dateAndTime.setText(currentDate);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        finalHour = hourOfDay;
        finalMinute = minute;
        hoursOfDate.setText(String.valueOf(finalHour));
        minutesOfDate.setText(String.valueOf(finalMinute));
    }

    public void OpenDatePicker(View view) {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(AgencyActivity.this, AgencyActivity.this, year, month, day);
        datePickerDialog.show();
    }


    public void AgencyScreenButton(View view) {
        Toast.makeText(this, "Sending...", Toast.LENGTH_LONG).show();
    }
}
