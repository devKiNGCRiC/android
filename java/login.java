package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    // Hardcoded valid credentials
    String validUsername = "admin";
    String validPassword = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin   = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter username and password",
                            Toast.LENGTH_SHORT).show();

                } else if (username.equals(validUsername) && password.equals(validPassword)) {
                    Toast.makeText(MainActivity.this,
                            "Login Successful! Welcome, " + username,
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this,
                            "Invalid username or password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
