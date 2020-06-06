package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PatternLockView patternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        patternLockView = findViewById(R.id.bloqueoPatronView);

        verificarSesion();


        final String definePatron = getIntent().getStringExtra("nuevo_patron");


        if (BaseDatos.obtenerPatron(MainActivity.this) == "null" && definePatron == null) {
            startActivity(new Intent(MainActivity.this, MenuOpciones.class));

        } else if (BaseDatos.obtenerPatron(MainActivity.this) != "null" || (BaseDatos.obtenerPatron(MainActivity.this).equals("null") && definePatron != null)) {

            patternLockView.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {

                    if (definePatron != null && definePatron.equals("1")) {
                        String nuevoPatron = PatternLockUtils.patternToString(patternLockView, pattern);
                        BaseDatos.actualizarPatron(MainActivity.this, nuevoPatron);
                        Toast.makeText(MainActivity.this, "Patron definido", Toast.LENGTH_SHORT).show();
                        pattern.clear();
                        finish();
                        startActivity(new Intent(MainActivity.this, MenuOpciones.class));
                    } else {
                        String patronIngresado = PatternLockUtils.patternToString(patternLockView, pattern);
                        if (BaseDatos.obtenerPatron(MainActivity.this).equals(patronIngresado)) {
                            pattern.clear();
                            finish();
                            startActivity(new Intent(MainActivity.this, MenuOpciones.class));
                            Toast.makeText(MainActivity.this, "Bienvenido!", Toast.LENGTH_SHORT).show();

                        } else if (BaseDatos.obtenerPatron(MainActivity.this) != "null" && BaseDatos.obtenerPatron(MainActivity.this).equals(patronIngresado) == false) {
                            pattern.clear();
                            Toast.makeText(MainActivity.this, "Patron incorrecto", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onCleared() {

                }
            });
        }

    }

    private void verificarSesion() {
        String value = getIntent().getStringExtra("sesion") == null ? "0" : getIntent().getStringExtra("sesion");

        if (value.equals("1")) {
            finish();
        }

    }


}
