package com.example.textquestsamsungitacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tx_bad_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_final);

        tx_bad_final = (TextView) findViewById(R.id.tx_bad_final);
        tx_bad_final.setText(getIntent().getStringExtra("et"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
    }
}