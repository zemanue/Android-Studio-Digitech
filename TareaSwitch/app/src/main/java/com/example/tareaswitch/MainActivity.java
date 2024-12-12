package com.example.tareaswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Switch switchMobileData, switchWiFi;
    Button buttonCheck;

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

        switchMobileData = findViewById(R.id.switchMobileData);
        switchWiFi = findViewById(R.id.switchWiFi);
        buttonCheck = findViewById(R.id.buttonCheck);
    }

    public void checkConnection(View v){
        String checkConnectionText;
        if (switchMobileData.isChecked() && switchWiFi.isChecked()) {
            checkConnectionText = "Los datos móviles y la conexión WiFi están activados.";
        } else if (switchMobileData.isChecked()) {
            checkConnectionText = "Solo los datos móviles están activados";
        } else if (switchWiFi.isChecked()) {
            checkConnectionText = "Solo la conexión WiFi está activada";
        } else {
            checkConnectionText = "Los datos móviles y la conexión WiFi están desactivados";
        }

        Toast.makeText(this, checkConnectionText, Toast.LENGTH_SHORT).show();
    }
}