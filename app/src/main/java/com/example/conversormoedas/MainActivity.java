package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editValue;
    private EditText editValueDolar;
    private EditText editValuePeso;
    private TextView textDolar;
    private TextView textPeso;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValue = findViewById(R.id.edit_value);
        editValueDolar = findViewById(R.id.edit_value_dolar);
        editValuePeso = findViewById(R.id.edit_value_peso);
        textDolar = findViewById(R.id.text_dolar);
        textPeso = findViewById(R.id.text_peso);
        buttonCalculate = findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(this);

        this.clearValues();

    }

    private void clearValues() {
        textDolar.setText("");
        textPeso.setText("");
    }

    @Override
    public void onClick(View v) {
        editValue.getText();
        editValueDolar.getText();
        editValuePeso.getText();
        textDolar.getText();
        textPeso.getText();
        buttonCalculate.getBottom();

        if (v.getId() == R.id.button_calculate) {
            String value = editValue.getText().toString();
            String valueDolar = editValueDolar.getText().toString();
            String valuePeso = editValuePeso.getText().toString();

            if ("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.informe_um_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);
                Double coatacaoDolar = Double.valueOf(valueDolar);
                Double cotacaoPeso = Double.valueOf(valuePeso);

                textDolar.setText(String.format("%.2f", real / coatacaoDolar));
                textPeso.setText(String.format("%.2f", real * cotacaoPeso));
            }
        }
    }

}