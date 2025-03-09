package com.example.layoutorientacionpantalla;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void portraitScreenOrientation (View v) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toast.makeText(this, "Orientación vertical", Toast.LENGTH_SHORT).show();
    }

    public void landscapeScreenOrientation (View v) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Toast.makeText(this, "Orientación horizontal", Toast.LENGTH_SHORT).show();
    }

    public void automaticScreenOrientation (View v) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        Toast.makeText(this, "Orientación automática", Toast.LENGTH_SHORT).show();
    }
}