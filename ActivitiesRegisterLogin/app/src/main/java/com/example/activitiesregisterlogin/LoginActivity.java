package com.example.activitiesregisterlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText editTextId, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextId = findViewById(R.id.editTextIdLogin);
        editTextPassword = findViewById(R.id.editTextPasswordLogin);
    }

    public void login(View v) {
        String id = editTextId.getText().toString();
        String password = editTextPassword.getText().toString();

        if (id.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, introduzca el Id y la contraseña", Toast.LENGTH_SHORT).show();
        } else {
            // Obtener los datos del intent
            if (getIntent().getStringExtra("id").equals(id)
                    && getIntent().getStringExtra("password").equals(password)) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, IndexActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("password", password);
                startActivity(intent);

            } else {
                Toast.makeText(this, "El Id o la contraseña son incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}