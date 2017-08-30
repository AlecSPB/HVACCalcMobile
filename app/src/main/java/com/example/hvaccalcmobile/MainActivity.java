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
    }

    // Метод обработки нажатия на кнопку
    public void openKvsActivity(View view){
        // Создание объекта Intent
        Intent intent = new Intent(this, KvsActivity.class);
        startActivity(intent);
    }
}