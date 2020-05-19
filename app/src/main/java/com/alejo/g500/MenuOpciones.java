package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuOpciones extends AppCompatActivity {
    private CardView btnPatronBloqueo, btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        btnPatronBloqueo = findViewById(R.id.btnPatronBloqueo);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnPatronBloqueo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuOpciones.this, MainActivity.class);
                intent.putExtra("nuevo_patron", "1");
                startActivity(intent);
            }
        });


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOpciones.this, Registro.class));
            }
        });

    }
}
