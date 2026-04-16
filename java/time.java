package com.example.timepickerapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnPickTime;
    TextView tvSelectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPickTime    = findViewById(R.id.btnPickTime);
        tvSelectedTime = findViewById(R.id.tvSelectedTime);

        btnPickTime.setOnClickListener(v -> showTimePicker());
    }

    void showTimePicker() {
        // Get current time as default
        Calendar calendar = Calendar.getInstance();
        int hour   = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
            this,
            (view, selectedHour, selectedMinute) -> {
                // Determine AM or PM
                String amPm  = selectedHour >= 12 ? "PM" : "AM";
                int hour12   = selectedHour % 12;
                if (hour12 == 0) hour12 = 12; // 0 should show as 12

                // Format minute to always show 2 digits (e.g. 07 not 7)
                String minute2digit = String.format("%02d", selectedMinute);

                String time = hour12 + " : " + minute2digit + " " + amPm;
                tvSelectedTime.setText("Selected Time:\n" + time);
            },
            hour, minute,
            false  // false = 12-hour format with AM/PM
        );

        timePickerDialog.show();
    }
}
