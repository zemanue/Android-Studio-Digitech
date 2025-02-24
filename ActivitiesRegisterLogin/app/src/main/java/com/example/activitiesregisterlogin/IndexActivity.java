package com.example.activitiesregisterlogin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IndexActivity extends AppCompatActivity {

    TextView textViewTitleIndexActivity, textViewTitleIndexActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_index);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewTitleIndexActivity = findViewById(R.id.textViewTitleIndexActivity);
        textViewTitleIndexActivity2 = findViewById(R.id.textViewTitleIndexActivity2);

        String id = getIntent().getStringExtra("id");
        String password = getIntent().getStringExtra("password");

        textViewTitleIndexActivity.setText("Welcome, " + id);
        textViewTitleIndexActivity2.setText("ID: " + id + "\n Password: " + password);
    }
}