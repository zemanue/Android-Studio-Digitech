package com.example.tareadadosimagebutton;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageFirstDice;
    ImageView imageSecondDice;

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

        imageFirstDice = findViewById(R.id.imageSecondDice);
        imageSecondDice = findViewById(R.id.imageFirstDice);
    }

    public void throwDices(View v) {
        Random random1to6 = new Random();
        int resultDice1 = random1to6.nextInt(6) + 1;
        switch (resultDice1) {
            case 1:
                imageFirstDice.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                imageFirstDice.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                imageFirstDice.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                imageFirstDice.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                imageFirstDice.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                imageFirstDice.setImageResource(R.drawable.dice_6);
                break;
            default:
                imageFirstDice.setImageResource(R.drawable.ic_launcher_foreground);
                break;
        }

    }

}