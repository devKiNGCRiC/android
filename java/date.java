package com.example.datepickerapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnPickDate;
    TextView tvSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPickDate    = findViewById(R.id.btnPickDate);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);

        btnPickDate.setOnClickListener(v -> showDatePicker());
    }

    void showDatePicker() {
        // Get today's date as default
        Calendar calendar = Calendar.getInstance();
        int year  = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day   = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
            this,
            (view, selectedYear, selectedMonth, selectedDay) -> {
                // Month is 0-based, so add 1
                String date = selectedDay + " / " + (selectedMonth + 1) + " / " + selectedYear;
                tvSelectedDate.setText("Selected Date:\n" + date);
            },
            year, month, day
        );

        datePickerDialog.show();
    }
}
