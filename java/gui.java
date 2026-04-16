package com.example.guiapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvOutput;
    EditText editText;
    Button btnShow;
    CheckBox checkBox;
    RadioGroup radioGroup;
    ToggleButton toggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOutput   = findViewById(R.id.tvOutput);
        editText   = findViewById(R.id.editText);
        btnShow    = findViewById(R.id.btnShow);
        checkBox   = findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        toggleBtn  = findViewById(R.id.toggleBtn);

        // Button click → show typed text
        btnShow.setOnClickListener(v -> {
            String text = editText.getText().toString().trim();
            if (text.isEmpty()) {
                tvOutput.setText("Please type something!");
                tvOutput.setTextColor(Color.RED);
            } else {
                tvOutput.setText("You typed: " + text);
                tvOutput.setTextColor(Color.parseColor("#7B1FA2"));
            }
        });

        // CheckBox
        checkBox.setOnCheckedChangeListener((btn, isChecked) ->
            Toast.makeText(this,
                isChecked ? "Terms Accepted ✓" : "Terms Not Accepted",
                Toast.LENGTH_SHORT).show()
        );

        // RadioGroup → change output text color
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioRed)        tvOutput.setTextColor(Color.RED);
            else if (checkedId == R.id.radioGreen) tvOutput.setTextColor(Color.GREEN);
            else if (checkedId == R.id.radioBlue)  tvOutput.setTextColor(Color.BLUE);
        });

        // ToggleButton → simulate dark/light mode message
        toggleBtn.setOnCheckedChangeListener((btn, isChecked) ->
            Toast.makeText(this,
                isChecked ? "Dark Mode ON 🌙" : "Dark Mode OFF ☀️",
                Toast.LENGTH_SHORT).show()
        );
    }
}
