package com.example.hvaccalcmobile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

public class AirDuctRActivity extends AppCompatActivity {

    TextView flowRateTextView;
    TextView widthTextView;
    TextView heightTextView;
    TextView temperatureTextView;
    TextView roughnessTextView;
    TextView diameterLabelTextView;
    TextView diameterTextView;
    TextView velocityLabelTextView;
    TextView velocityTextView;
    TextView pressureDropLabelTextView;
    TextView pressureDropTextView;

    EditText flowRateEditText;
    EditText widthEditText;
    EditText heightEditText;
    EditText temperatureEditText;
    EditText roughnessEditText;

    Button calculateButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_duct_r);

        setTitle("Расчет прямоуг. воздуховода");

        flowRateTextView = (TextView) findViewById(R.id.flowRateTextView);
        widthTextView = (TextView) findViewById(R.id.widthTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        roughnessTextView = (TextView) findViewById(R.id.roughnessTextView);
        diameterLabelTextView = (TextView) findViewById(R.id.diameterLabelTextView);
        diameterTextView = (TextView) findViewById(R.id.diameterTextView);
        velocityLabelTextView = (TextView) findViewById(R.id.velocityLabelTextView);
        velocityTextView = (TextView) findViewById(R.id.velocityTextView);
        pressureDropLabelTextView = (TextView) findViewById(R.id.pressureDropLabelTextView);
        pressureDropTextView = (TextView) findViewById(R.id.pressureDropTextView);

        flowRateEditText = (EditText) findViewById(R.id.flowRateEditText);
        widthEditText = (EditText) findViewById(R.id.widthEditText);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        temperatureEditText = (EditText) findViewById(R.id.temperatureEditText);
        roughnessEditText = (EditText) findViewById(R.id.roughnessEditText);

        widthEditText.requestFocus();

    }


    public void printResult(View view) {
        // При нажатии на кнопку убирается клавиатура
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        Float flowRate = null;
        try {
            flowRate = Float.parseFloat(flowRateEditText.getText().toString());
        } catch (NumberFormatException e) {
            flowRateEditText.setText("Ошибка");
        }
        Float width = null;
        try {
            width = Float.parseFloat(widthEditText.getText().toString());
        } catch (NumberFormatException e) {
            widthEditText.setText("Ошибка");
        }
        Float height = null;
        try {
            height = Float.parseFloat(heightEditText.getText().toString());
        } catch (NumberFormatException e) {
            heightEditText.setText("Ошибка");
        }
        Float temperature = null;
        try {
            temperature = Float.parseFloat(temperatureEditText.getText().toString());
        } catch (NumberFormatException e) {
            temperatureEditText.setText("Ошибка");
        }
        Float roughness = null;
        try {
            roughness = Float.parseFloat(roughnessEditText.getText().toString());
        } catch (NumberFormatException e) {
            roughnessEditText.setText("Ошибка");
        }

        if (flowRate == null || width == null || height == null || temperature == null || roughness == null){
            diameterTextView.setText("Ошибка");
            velocityTextView.setText("Ошибка");
            pressureDropTextView.setText("Ошибка");
        } else {
            AirDuctCalculator calc = new AirDuctCalculator(flowRate, width, height, temperature, roughness);
            diameterTextView.setText(calc.getDiameter().toString());
            velocityTextView.setText(calc.getVelocity().toString());
            pressureDropTextView.setText(calc.getPressureDrop().toString());
        }

    }

    public void clearFields(View view) {
        flowRateEditText.setText("");
        widthEditText.setText("");
        heightEditText.setText("");
        temperatureEditText.setText("");
        roughnessEditText.setText("");
        widthEditText.requestFocus();
        diameterTextView.setText("");
        velocityTextView.setText("");
        pressureDropTextView.setText("");
    }
}
