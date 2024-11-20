
// 1.Diseñar una aplicación con una caja de texto y un botón, cuando se pulsa el botón aparece el
// texto tecleado en la caja en un mensaje de tipo Toast.

package com.example.tareaelementostipotexto;

// Importamos las clases necesarias
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaramos los objetos que hacen referencia a los elementos de la interfaz que hemos añadido.
    private EditText userInput;
    private Button sendInputButton;

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

        // Se enlazan las variables con los elementos de la interfaz
        sendInputButton = findViewById(R.id.sendInputButton);
        userInput = findViewById(R.id.userInput);

        // Asociar un objeto OnClickListener al botón, que es el objeto que reacciona al click
        View.OnClickListener listener = new View.OnClickListener() {
            @Override // Hace falta sobrescribir el metodo onClick de esta interfaz indicándole qué debe hacer
            public void onClick(View v) {
                // Añadimos el mensaje de tipo Toast
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        };
    }
}