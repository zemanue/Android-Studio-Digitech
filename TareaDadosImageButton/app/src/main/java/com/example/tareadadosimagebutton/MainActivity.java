package com.example.tareadadosimagebutton;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageFirstDice, imageSecondDice;
    TextView textViewResult;
    // Un array de enteros que contiene las imágenes de los dados (R.drawable.dice_x devuelve un entero)
    int[] diceImages = {
            R.drawable.ic_launcher_foreground, // Imagen por defecto para que ocupe el índice 0
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };


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

        imageFirstDice = findViewById(R.id.imageFirstDice);
        imageSecondDice = findViewById(R.id.imageSecondDice);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void throwDices(View v) {
        // Reproduce un sonido de lanzar dados
        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        mp.start();

        // Cambiar la imagen de los dados, guardando el resultado obtenido
        int valueFirstDice = changeDiceImage(imageFirstDice);
        int valueSecondDice = changeDiceImage(imageSecondDice);

        // Si los dados han salido iguales, avisa con un Toast
        if (valueFirstDice == valueSecondDice) {
            Toast.makeText(this, "¡Dados dobles!", Toast.LENGTH_SHORT).show();
        }

        // Mostrar el resultado de la suma de los dados
        int totalValue = valueFirstDice + valueSecondDice;
        textViewResult.setText(valueFirstDice + " + " + valueSecondDice + " = " + totalValue);
    }

    public int changeDiceImage(ImageView diceImage) {
        Random random1to6 = new Random();
        int diceResult = random1to6.nextInt(6) + 1; // Obtenemos un entero aleatorio entre 1 y 6

        // Se elige la imagen del array diceImages correspondiente al valor obtenido
        diceImage.setImageResource(diceImages[diceResult]);

        // Al devolver un entero, podemos guardar el resultado del dado en una variable
        return diceResult;
    }

}