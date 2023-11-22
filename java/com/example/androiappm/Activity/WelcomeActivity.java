package com.example.androiappm.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androiappm.R;

public class WelcomeActivity extends AppCompatActivity {
Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        // Assuming your button has an id "button" in your welcome_main layout
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });
    }

    public void register(View view) {
        Intent intent = new Intent(WelcomeActivity.this, Registration.class);
        startActivity(intent);
    }

    public void login(View view) {
        Intent intent = new Intent(WelcomeActivity.this, Login.class);
        startActivity(intent);
    }
}
