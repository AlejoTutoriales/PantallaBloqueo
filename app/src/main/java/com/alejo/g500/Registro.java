package com.alejo.g500;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText cajaGasolinaIncial, cajaGasolinaFinal;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      //  inicializarElementos();
        //clicks();

    }

    private void clicks() {

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gInicial = cajaGasolinaIncial.getText().toString().trim();
                String gFinal = cajaGasolinaFinal.getText().toString().trim();

                if (gInicial.isEmpty() || gFinal.isEmpty()) {
                    Toast.makeText(Registro.this, "Algún dato faltante", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registro.this, "Información almacenada!", Toast.LENGTH_SHORT).show();
                    btnGuardar.setEnabled(false);
                    cajaGasolinaIncial.setEnabled(false);
                    cajaGasolinaFinal.setEnabled(false);
                }
            }
        });

    }

    private void inicializarElementos() {


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}
