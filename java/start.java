package com.example.counterapp;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView tvCounter, tvWord;

    Handler handler = new Handler();
    int count = 0;
    boolean isRunning = false;

    // Words for numbers 1 to 20, after that use number itself
    String[] words = {
        "Zero", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
    };

    Runnable counterRunnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                count++;

                // Show number in circle
                tvCounter.setText(String.valueOf(count));

                // Show word below if count <= 20, else just show number
                if (count <= 20) {
                    tvWord.setText(words[count]);
                } else {
                    tvWord.setText("Count: " + count);
                }

                // Repeat every 1 second
                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart  = findViewById(R.id.btnStart);
        btnStop   = findViewById(R.id.btnStop);
        tvCounter = findViewById(R.id.tvCounter);
        tvWord    = findViewById(R.id.tvWord);

        btnStart.setOnClickListener(v -> {
            if (!isRunning) {
                isRunning = true;
                tvWord.setText("Counting...");
                handler.post(counterRunnable);
            }
        });

        btnStop.setOnClickListener(v -> {
            if (isRunning) {
                isRunning = false;
                handler.removeCallbacks(counterRunnable);
                tvWord.setText("Stopped at " + count);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(counterRunnable);
    }
}
