package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.editValueDolar = findViewById(R.id.edit_value_dolar);
        this.mViewHolder.editValuePeso = findViewById(R.id.edit_value_peso);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textPeso = findViewById(R.id.text_peso);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String value = this.mViewHolder.editValue.getText().toString();
            String valueDolar = this.mViewHolder.editValueDolar.getText().toString();
            String valuePeso = this.mViewHolder.editValuePeso.getText().toString();

            if ("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.informe_um_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);
                Double coatacaoDolar = Double.valueOf(valueDolar);
                Double cotacaoPeso = Double.valueOf(valuePeso);

                this.mViewHolder.textDolar.setText(String.format("%.2f", real / coatacaoDolar));
                this.mViewHolder.textPeso.setText(String.format("%.2f", real * cotacaoPeso));
            }
        }
    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textPeso.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        EditText editValueDolar;
        EditText editValuePeso;
        TextView textDolar;
        TextView textPeso;
        Button buttonCalculate;
    }
}
