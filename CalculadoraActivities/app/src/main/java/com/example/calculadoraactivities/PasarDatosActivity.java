package com.example.calculadoraactivities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PasarDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pasar_datos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Recuperamos los datos de la MainActivity (num1, num2 y result)
        double num1 = getIntent().getDoubleExtra("num1", 0);
        String selectedOperation = getIntent().getStringExtra("selectedOperation");
        double num2 = getIntent().getDoubleExtra("num2", 0);
        double result = getIntent().getDoubleExtra("result", 0);

        // Mostramos los datos en los TextView correspondientes
        TextView textView2ActivityNum1 = findViewById(R.id.textView2ActivityNum1);
        TextView textView2ActivityOperation = findViewById(R.id.textView2ActivityOperation);
        TextView textView2ActivityNum2 = findViewById(R.id.textView2ActivityNum2);
        TextView textView2ActivityResult = findViewById(R.id.textView2ActivityResult);

        // Mostramos los datos
        textView2ActivityNum1.setText(String.valueOf(num1));
        textView2ActivityOperation.setText(selectedOperation);
        textView2ActivityNum2.setText(String.valueOf(num2));
        textView2ActivityResult.setText(String.valueOf(result));

    }

    public void returnMainActivity(View v) {
        // Volvemos a la MainActivity
        finish();
    }
}