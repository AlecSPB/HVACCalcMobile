package com.example.hvaccalcmobile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AirDuctCActivity extends AppCompatActivity {

    TextView diameterTextView;
    TextView temperatureTextView;
    TextView roughnessTextView;
    TextView flowRateTextView;
    TextView velocityLabelTextView;
    TextView velocityTextView;
    TextView pressureDropLabelTextView;
    TextView pressureDropTextView;


    EditText diameterEditText;
    EditText temperatureEditText;
    EditText roughnessEditText;
    EditText flowRateEditText;

    Button calculateButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_duct_c);

        setTitle("Расчет круглого воздуховода");

        flowRateTextView = (TextView) findViewById(R.id.flowRateTextView);
        diameterTextView = (TextView) findViewById(R.id.diameterTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        roughnessTextView = (TextView) findViewById(R.id.roughnessTextView);
        diameterTextView = (TextView) findViewById(R.id.diameterTextView);
        velocityLabelTextView = (TextView) findViewById(R.id.velocityLabelTextView);
        velocityTextView = (TextView) findViewById(R.id.velocityTextView);
        pressureDropLabelTextView = (TextView) findViewById(R.id.pressureDropLabelTextView);
        pressureDropTextView = (TextView) findViewById(R.id.pressureDropTextView);

        flowRateEditText = (EditText) findViewById(R.id.flowRateEditText);
        diameterEditText = (EditText) findViewById(R.id.diameterEditText);
        temperatureEditText = (EditText) findViewById(R.id.temperatureEditText);
        roughnessEditText = (EditText) findViewById(R.id.roughnessEditText);

        diameterEditText.requestFocus();
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
        Float diameter = null;
        try {
            diameter = Float.parseFloat(diameterEditText.getText().toString());
        } catch (NumberFormatException e) {
            diameterEditText.setText("Ошибка");
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

        if (flowRate == null || diameter == null || temperature == null || roughness == null){
            velocityTextView.setText("Ошибка");
            pressureDropTextView.setText("Ошибка");
        } else {
            AirDuctCalculator calc = new AirDuctCalculator(flowRate, diameter, temperature, roughness);
            velocityTextView.setText(calc.getVelocity().toString());
            pressureDropTextView.setText(calc.getPressureDrop().toString());
        }


    }

    public void clearFields(View view) {
        flowRateEditText.setText("");
        diameterEditText.setText("");
        diameterEditText.requestFocus();
        temperatureEditText.setText("");
        roughnessEditText.setText("");
        velocityTextView.setText("");
        pressureDropTextView.setText("");

    }
}
