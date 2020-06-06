package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.alejo.g500.objetos.Constantes;
import com.alejo.g500.objetos.Usuario;

public class MenuOpciones extends AppCompatActivity {
    private CardView btnPatronBloqueo, btnRegistro, btnPreciosGasolinas, btnReportes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        btnPatronBloqueo = findViewById(R.id.btnPatronBloqueo);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnPreciosGasolinas = findViewById(R.id.btnPreciosGasolinas);
        btnReportes = findViewById(R.id.btnReportes);


        if (Constantes.USUARIO_LOGIN.getTipo_usuario().equals("1")) {
            btnPreciosGasolinas.setVisibility(View.VISIBLE);
        } else {
            btnPreciosGasolinas.setVisibility(View.GONE);

        }

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

        btnPreciosGasolinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOpciones.this, ConfiguracionGasolina.class));
            }
        });
        btnReportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOpciones.this, Reportes.class));
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MenuOpciones.this);
        builder.setTitle("Cerrar Sesión");
        builder.setMessage("¿Deseas cerrar tu sesión, " + Constantes.USUARIO_LOGIN.getNombre() + "?");
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(MenuOpciones.this, Login.class);
                startActivity(i);
                finish();

            }
        })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create().show();


    }
}
