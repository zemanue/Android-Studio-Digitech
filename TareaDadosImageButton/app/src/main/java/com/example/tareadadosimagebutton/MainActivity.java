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
        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        mp.start();
        int valueFirstDice = changeDiceImage(imageFirstDice);
        int valueSecondDice = changeDiceImage(imageSecondDice);
        int totalValue = valueFirstDice + valueSecondDice;
        if (valueFirstDice == valueSecondDice) {
            Toast.makeText(this, "¡Dados dobles!", Toast.LENGTH_SHORT).show();
        }
        textViewResult.setText(valueFirstDice + " + " + valueSecondDice + " = " + totalValue);
    }

    public int changeDiceImage(ImageView diceImage) {
        Random random1to6 = new Random();
        int diceResult = random1to6.nextInt(6) + 1;
        switch (diceResult) {
            case 1:
                diceImage.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                diceImage.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.dice_6);
                break;
            default:
                diceImage.setImageResource(R.drawable.ic_launcher_foreground);
                break;
        }
        return diceResult;
    }

}