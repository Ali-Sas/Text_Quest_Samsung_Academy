package com.example.textquestsamsungitacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.textquestsamsungitacademy.DATA.DATA;

public class MainActivity extends AppCompatActivity {
    TextView tx_welcome;
    Button bt_start;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx_welcome = (TextView) findViewById(R.id.tx_welcome);
        bt_start = (Button) findViewById(R.id.bt_start);

        tx_welcome.setText(DATA.welcome_text);
        bt_start.setText("start");

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DATA.setCount_task(0);
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }
}