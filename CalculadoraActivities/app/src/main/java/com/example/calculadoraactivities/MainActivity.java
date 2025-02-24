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
        // Comprobamos que los Edit Text no estén vacíos
        String text1 = editTextNum1.getText().toString().trim();
        String text2 = editTextNum2.getText().toString().trim();
        if(text1.isEmpty() || text2.isEmpty()) {
            Toast.makeText(this, "Introduce dos números antes de intentar calcular", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtenemos la operación seleccionada del Spinner
        String selectedOperation = spinnerSelectOp.getSelectedItem().toString().toLowerCase();

        // Parseamos el texto a double y calculamos el resultado
        double num1 = Double.parseDouble(text1);
        double num2 = Double.parseDouble(text2);
        double result = calculate(num1, num2, selectedOperation);

        // Convertimos el nombre de la operación en su símbolo correspondiente
        if (selectedOperation.equals("sumar")) {
            selectedOperation = "+";
        } else if (selectedOperation.equals("restar")) {
            selectedOperation = "-";
        } else if (selectedOperation.equals("multiplicar")) {
            selectedOperation = "*";
        } else if (selectedOperation.equals("dividir")) {
            selectedOperation = "/";
        }

        // Creamos el Intent, pasamos los datos y lanzamos la actividad
        Intent intent = new Intent(this, PasarDatosActivity.class);
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        intent.putExtra("selectedOperation", selectedOperation);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    public double calculate(double num1, double num2, String selectedOperation) {

        switch (selectedOperation) {
            case "sumar":
                return num1 + num2;
//                textViewResultOp.setText("Suma: " + num1 + " + " + num2 + " = " + (num1 + num2));
            case "restar":
                return num1 - num2;
//                textViewResultOp.setText("Resta: " + num1 + " - " + num2 + " = " + (num1 - num2));
            case "multiplicar":
                return num1 * num2;
//                textViewResultOp.setText("Multiplicación: " + num1 + " * " + num2 + " = " + (num1 * num2));
            case "dividir":
                return num1 / num2;
//                textViewResultOp.setText("División: " + + num1 + " / " + num2 + " = " + (num1 / num2));
            default:
                return 0;
//                textViewResultOp.setText("Error");
        }
    }
}