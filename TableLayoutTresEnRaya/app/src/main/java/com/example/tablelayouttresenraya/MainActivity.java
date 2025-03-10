package com.example.tablelayouttresenraya;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String jugador = "X";

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

    public void rellenarCasilla(View v) {
        Button button = (Button) v;
        if (button.getText().toString().equals("-")) {
            button.setText(jugador);
            cambiarJugador();
        } else {
            return;
        }
    }

    public void cambiarJugador(){
        if (jugador.equals("X")){
            jugador = "O";
        } else {
            jugador = "X";
        }
    }

    public void restart(View v){
        jugador = "X";
        // Recorrer todos los botones del tablero y establecer "-" en su texto
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        for (int i = 0; i < 3; i++) { // Primer bucle: recorre las filas de la tabla (TableLayout)
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < 3; j++) { // Segundo bucle: recorre cada elemento de la fila (TableRow)
                Button button = (Button) row.getChildAt(j);
                button.setText("-");
            }
        }
    }
}