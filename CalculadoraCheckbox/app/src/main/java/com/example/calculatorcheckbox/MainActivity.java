package com.example.calculatorcheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private EditText editTextNum1, editTextNum2;
    private RadioButton radioButtonSum, radioButtonSubst, radioButtonMult, radioButtonDiv;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);

        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResultSum);
    }

    public void calculate(View v){
        String text1 = editTextNum1.getText().toString().trim();
        String text2 = editTextNum2.getText().toString().trim();
        if(text1.isEmpty() || text2.isEmpty()) {
            Toast.makeText(this, "Introduce dos números antes de intentar calcular", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(text1);
            double num2 = Double.parseDouble(text2);
            double result = 0.0;
            if (radioButtonSum.isChecked()) {
                result = num1 + num2;
            } else if (radioButtonSubst.isChecked()) {
                result = num1 - num2;
            } else if (radioButtonMult.isChecked()) {
                result = num1 * num2;
            } else if (radioButtonDiv.isChecked()) {
                if(num2 == 0) {
                    Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                } else {
                    result = num1 / num2;
                }
            } else {
                Toast.makeText(this, "Elige una operación para calcular", Toast.LENGTH_SHORT).show();
            }

            textViewResult.setText("El resultado es: " + String.valueOf(result));
        }
    }
}