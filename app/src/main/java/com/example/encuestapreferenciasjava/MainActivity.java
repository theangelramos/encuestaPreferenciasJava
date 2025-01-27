package com.example.encuestapreferenciasjava;

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
    EditText txtColor;
    EditText txtComida;
    Button btnEnviar;

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

        txtColor = findViewById(R.id.colorInput);
        txtComida = findViewById(R.id.comidaInput);
        btnEnviar = findViewById(R.id.enviarButton);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colorFavorito = txtColor.getText().toString();
                String comidaFavorita = txtComida.getText().toString();

                if (colorFavorito.isEmpty() || comidaFavorita.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.this,
                            "Color Favorito: " + colorFavorito + "\nComida Favorita: " + comidaFavorita,
                            Toast.LENGTH_LONG).show();

                    txtColor.setText("");
                    txtComida.setText("");
                }
            }
        });
    }
}