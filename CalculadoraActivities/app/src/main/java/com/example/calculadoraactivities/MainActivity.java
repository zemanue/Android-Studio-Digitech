package com.example.calculadoraactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerSelectOp;
    EditText editTextNum1, editTextNum2;
    TextView textViewResultOp;

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
        textViewResultOp = findViewById(R.id.textViewResultOp);

        // Vinculamos el objeto Spinner
        spinnerSelectOp = findViewById(R.id.spinnerSelectOp);

        // Utilizamos el objeto ArrayAdapter para leer los datos
        String[] operations = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operations);

        // Vinculamos el objeto de tipo ArrayAdapter. Con setAdapter, se carga el spinner con los datos del objeto definido antes.
        spinnerSelectOp.setAdapter(adapter);

    }

    public void showDataActivity(View v) {
        calculate();
        // Creamos el objeto Intent e iniciamos la actividad
        Intent intent = new Intent(this, PasarDatosActivity.class);
        startActivity(intent);
    }

    public void calculate() {

        // Creamos la variable con los datos del spinner
        String selectedOperation = spinnerSelectOp.getSelectedItem().toString().toLowerCase();

        // Comprobamos la operación seleccionada
        String text1 = editTextNum1.getText().toString().trim();
        String text2 = editTextNum2.getText().toString().trim();
        if(text1.isEmpty() || text2.isEmpty()) {
            Toast.makeText(this, "Introduce dos números antes de intentar calcular", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(text1);
        double num2 = Double.parseDouble(text2);

        switch (selectedOperation) {
            case "sumar":
                textViewResultOp.setText("Suma: " + num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case "restar":
                textViewResultOp.setText("Resta: " + num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case "multiplicar":
                textViewResultOp.setText("Multiplicación: " + num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case "dividir":
                textViewResultOp.setText("División: " + + num1 + " / " + num2 + " = " + (num1 / num2));
                break;
            default:
                textViewResultOp.setText("Error");
                break;
        }
    }
}