package com.example.hvaccalcmobile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class KvsActivity extends AppCompatActivity {
    EditText flowRateEditText;
    EditText pressureEditText;
    EditText temperatureEditText;

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kvs);

        setTitle("Расчет Kvs");

        flowRateEditText = (EditText) findViewById(R.id.flowRateEditText);
        pressureEditText = (EditText) findViewById(R.id.pressureEditText);
        temperatureEditText = (EditText) findViewById(R.id.temperatureEditText);

        flowRateEditText.requestFocus();

        resultTextView = (TextView) findViewById(R.id.resultTextView);
    }


    public void printKvs(View view) {
        // При нажатии на кнопку убирается клавиатура
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        Double flowRate = 0.0;
        Double pressure = 0.0;
        Double temperature = 0.0;

        try {
            flowRate = Double.parseDouble(flowRateEditText.getText().toString());
        } catch (NumberFormatException e) {
            flowRateEditText.setText("Ошибка");
        }

        try {
            pressure = Double.parseDouble(pressureEditText.getText().toString());
        } catch (NumberFormatException e) {
            pressureEditText.setText("Ошибка");
        }

        try {
            temperature = Double.parseDouble(temperatureEditText.getText().toString());
        } catch (NumberFormatException e) {
            temperatureEditText.setText("Ошибка");
        }

        if (flowRate == 0.0 || pressure == 0.0){
            resultTextView.setText("Ошибка");
        } else {
            KvsCalculator calc = new KvsCalculator(flowRate, pressure, temperature);
            resultTextView.setText(calc.getKvs().toString());
        }

    }
}
