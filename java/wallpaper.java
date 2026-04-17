package com.example.wallpaperapp;

import android.app.WallpaperManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView tvStatus;
    ImageView imagePreview;

    Handler handler = new Handler();
    boolean isRunning = false;

    // Add all your drawable image IDs here
    int[] wallpapers = {
        R.drawable.wall1,
        R.drawable.wall2,
        R.drawable.wall3,
        R.drawable.wall4
    };

    Random random = new Random();

    Runnable wallpaperRunnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                changeWallpaper();
                // Schedule next change after 30 seconds
                handler.postDelayed(this, 30000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart     = findViewById(R.id.btnStart);
        btnStop      = findViewById(R.id.btnStop);
        tvStatus     = findViewById(R.id.tvStatus);
        imagePreview = findViewById(R.id.imagePreview);

        btnStart.setOnClickListener(v -> {
            if (!isRunning) {
                isRunning = true;
                tvStatus.setText("Wallpaper changing every 30 seconds...");
                // Change immediately on click, then every 30 sec
                handler.post(wallpaperRunnable);
                Toast.makeText(this, "Started!", Toast.LENGTH_SHORT).show();
            }
        });

        btnStop.setOnClickListener(v -> {
            isRunning = false;
            handler.removeCallbacks(wallpaperRunnable);
            tvStatus.setText("Stopped. Press START to resume.");
            Toast.makeText(this, "Stopped!", Toast.LENGTH_SHORT).show();
        });
    }

    void changeWallpaper() {
        // Pick a random wallpaper
        int randomIndex = random.nextInt(wallpapers.length);
        int resId = wallpapers[randomIndex];

        // Show preview in ImageView
        imagePreview.setImageResource(resId);

        // Set as system wallpaper
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
            wallpaperManager.setBitmap(bitmap);
            tvStatus.setText("Wallpaper " + (randomIndex + 1) + " set! Next in 30 sec...");
        } catch (IOException e) {
            tvStatus.setText("Error setting wallpaper: " + e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop handler when app is closed
        handler.removeCallbacks(wallpaperRunnable);
    }
}
