package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText cajaUsuario;
    EditText cajaPass;
    Button btnInciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializarElementos();
        clicks();
    }

    private void clicks() {
        btnInciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarEntradas();
            }
        });
    }

    private void validarEntradas() {
        String user = cajaUsuario.getText().toString();
        String pass = cajaPass.getText().toString();

        if (user.equals("") == false || pass.equals("") == false) {

            if (user.equals("Mauricio") == false) {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();

            } else if (pass.equals("ITVH") == false) {
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();

            } else if (user.equals("Mauricio") == false && pass.equals("ITVH") == false) {
                Toast.makeText(this, "La cuenta no existe", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Login.this, MenuOpciones.class));
            }
        } else {
            Toast.makeText(this, "Algún campo vacío", Toast.LENGTH_SHORT).show();

        }


    }

    private void inicializarElementos() {
        cajaUsuario = findViewById(R.id.cajaUsuario);
        cajaPass = findViewById(R.id.cajaPass);
        btnInciarSesion = findViewById(R.id.btnIniciarSesion);

    }


    public void irRegistro(View view) {
        startActivity(new Intent(Login.this, NuevoUsuario.class));
    }


}
