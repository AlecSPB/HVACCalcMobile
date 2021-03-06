package com.example.hvaccalcmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Расчеты");
    }

    public void showKvsActivity(View view) {
        Intent intent = new Intent(this, KvsActivity.class);
        startActivity(intent);
    }

    public void showAirDuctRActivity(View view) {
        Intent intent = new Intent(this, AirDuctRActivity.class);
        startActivity(intent);
    }

    public void showAirDuctCActivity(View view) {
        Intent intent = new Intent(this, AirDuctCActivity.class);
        startActivity(intent);
    }
}
