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
        userInput = findViewById(R.id.userInput);
        sendInputButton = findViewById(R.id.sendInputButton);

        // Forma programática:
        // Asociar un objeto OnClickListener al botón, que es el objeto que reacciona al click
        /* sendInputButton.setOnClickListener(new View.OnClickListener() {
            @Override // Hace falta sobrescribir el metodo onClick de esta interfaz indicándole qué debe hacer
            public void onClick(View v) {
                // Añadimos el mensaje de tipo Toast
                String inputMessage= userInput.getText().toString().trim();
                if (inputMessage.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Introduce texto en el cuadro para mostrarlo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, inputMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });*/

    }

    // Metodo alternativo del profesor:
    // Se crea un metodo y se asocia este metodo en el archivo xml con el atributo "OnClick"
    public void showText(View v) {
        String inputMessage= userInput.getText().toString().trim();
        if (inputMessage.isEmpty()) {
            Toast.makeText(MainActivity.this, "Introduce texto en el cuadro para mostrarlo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, inputMessage, Toast.LENGTH_SHORT).show();
        }
        // Además, hace falta añadir en el activity_main.xml la línea:
        // android:onClick="showText"
        // Esto se puede añadir manualmente en la etiqueta <Button> correspondiente
        // o automáticamente a través del modo diseño, en el atributo "onClick" del botón.
    }
}