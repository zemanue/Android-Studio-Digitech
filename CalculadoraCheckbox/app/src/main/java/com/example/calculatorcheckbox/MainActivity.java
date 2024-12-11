package com.example.calculatorcheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResultSum, textViewResultSubst, textViewResultMult, textViewResultDiv;
    private EditText editTextNum1, editTextNum2;
    private CheckBox checkBoxSum, checkBoxSubst, checkBoxMult, checkBoxDiv;

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

        checkBoxSum = findViewById(R.id.checkBoxSum);
        checkBoxSubst = findViewById(R.id.checkBoxSubst);
        checkBoxMult = findViewById(R.id.checkBoxMult);
        checkBoxDiv = findViewById(R.id.checkBoxDiv);

        textViewResultSum = findViewById(R.id.textViewResultSum);
        textViewResultSubst = findViewById(R.id.textViewResultSubst);
        textViewResultMult = findViewById(R.id.textViewResultMult);
        textViewResultDiv = findViewById(R.id.textViewResultDiv);
    }

    public void calculate(View v){
        String text1 = editTextNum1.getText().toString().trim();
        String text2 = editTextNum2.getText().toString().trim();
        if(text1.isEmpty() || text2.isEmpty()) {
            Toast.makeText(this, "Introduce dos números antes de intentar calcular", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(text1);
            double num2 = Double.parseDouble(text2);

            String textResultSum = "";
            String textResultSubst = "";
            String textResultMult = "";
            String textResultDiv = "";

            if (!checkBoxSum.isChecked()
                    && !checkBoxSubst.isChecked()
                    && !checkBoxMult.isChecked()
                    && !checkBoxDiv.isChecked()) {
                Toast.makeText(this, "Elige una operación para calcular", Toast.LENGTH_SHORT).show();
            } else {
                if (checkBoxSum.isChecked()) {
                    textResultSum = "El resultado de la suma es: " + (num1 + num2);
                } if (checkBoxSubst.isChecked()) {
                    textResultSubst = "El resultado de la resta es: " + (num1 - num2);
                } if (checkBoxMult.isChecked()) {
                    textResultMult = "El resultado de la mutiplicación es: " + (num1 * num2);
                } if (checkBoxDiv.isChecked()) {
                    if(num2 == 0) {
                        Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                    } else {
                        textResultDiv = "El resultado de la división es: " + (num1 / num2);
                    }
                }
            }

            textViewResultSum.setText(textResultSum);
            textViewResultSubst.setText(textResultSubst);
            textViewResultMult.setText(textResultMult);
            textViewResultDiv.setText(textResultDiv);
        }
    }
}