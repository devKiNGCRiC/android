package com.example.colorchange;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
    }

    // Inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.color_red) {
            mainLayout.setBackgroundColor(Color.RED);
        } else if (id == R.id.color_green) {
            mainLayout.setBackgroundColor(Color.GREEN);
        } else if (id == R.id.color_blue) {
            mainLayout.setBackgroundColor(Color.BLUE);
        } else if (id == R.id.color_yellow) {
            mainLayout.setBackgroundColor(Color.YELLOW);
        } else if (id == R.id.color_white) {
            mainLayout.setBackgroundColor(Color.WHITE);
        } else if (id == R.id.color_black) {
            mainLayout.setBackgroundColor(Color.BLACK);
        }

        return true;
    }
}
