package com.alejo.g500;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    EditText cajaGasolinaIncialBOMBA1_DES1, cajaGasolinaFinalBOMBA1_DES1;
    EditText cajaGasolinaIncialBOMBA2_DES1, cajaGasolinaFinalBOMBA2_DES1;
    EditText cajaGasolinaIncialBOMBA1_DES2, cajaGasolinaFinalBOMBA1_DES2;
    EditText cajaGasolinaIncialBOMBA2_DES2, cajaGasolinaFinalBOMBA2_DES2;
    EditText cajaGasolinaIncialBOMBA1_DES3, cajaGasolinaFinalBOMBA1_DES3;
    EditText cajaGasolinaIncialBOMBA2_DES3, cajaGasolinaFinalBOMBA2_DES3;
    EditText cajaGasolinaIncialBOMBA1_DES4, cajaGasolinaFinalBOMBA1_DES4;
    EditText cajaGasolinaIncialBOMBA2_DES4, cajaGasolinaFinalBOMBA2_DES4;


    Button btnGuardarIncialBOMBA1_DES1, btnGuardarFinalBOMBA1_DES1;
    Button btnGuardarIncialBOMBA2_DES1, btnGuardarFinalBOMBA2_DES1;
    Button btnGuardarIncialBOMBA1_DES2, btnGuardarFinalBOMBA1_DES2;
    Button btnGuardarIncialBOMBA2_DES2, btnGuardarFinalBOMBA2_DES2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inicializarElementos();
        //clicks();

    }

    private void clicks() {


    }

    private void inicializarElementos() {
        //CAJAS DE TEXTO
        cajaGasolinaIncialBOMBA1_DES1 = findViewById(R.id.gasolinaInicialB1D1);
        cajaGasolinaFinalBOMBA1_DES1 = findViewById(R.id.gasolinaFinalB1D1);
        cajaGasolinaIncialBOMBA2_DES1 = findViewById(R.id.gasolinaInicialB2D1);
        cajaGasolinaFinalBOMBA2_DES1 = findViewById(R.id.gasolinaFinalB2D1);
        cajaGasolinaIncialBOMBA1_DES2 = findViewById(R.id.gasolinaInicialB1D2);
        cajaGasolinaFinalBOMBA1_DES2 = findViewById(R.id.gasolinaFinalB1D2);
        cajaGasolinaIncialBOMBA2_DES2 = findViewById(R.id.gasolinaInicialB2D2);
        cajaGasolinaFinalBOMBA2_DES2 = findViewById(R.id.gasolinaFinalB2D2);
        cajaGasolinaIncialBOMBA1_DES3 = findViewById(R.id.gasolinaInicialB1D3);
        cajaGasolinaFinalBOMBA1_DES3 = findViewById(R.id.gasolinaFinalB1D3);
        cajaGasolinaIncialBOMBA2_DES3 = findViewById(R.id.gasolinaInicialB2D3);
        cajaGasolinaFinalBOMBA2_DES3 = findViewById(R.id.gasolinaFinalB2D3);
        cajaGasolinaIncialBOMBA1_DES4 = findViewById(R.id.gasolinaInicialB1D4);
        cajaGasolinaFinalBOMBA1_DES4 = findViewById(R.id.gasolinaFinalB1D4);
        cajaGasolinaIncialBOMBA2_DES4 = findViewById(R.id.gasolinaInicialB2D4);
        cajaGasolinaFinalBOMBA2_DES4 = findViewById(R.id.gasolinaFinalB2D4);

        //BOTONES
        btnGuardarIncialBOMBA1_DES1 = findViewById(R.id.btnGuardarIncialBOMBA1_DES1);
        btnGuardarFinalBOMBA1_DES1 = findViewById(R.id.btnGuardarFinalBOMBA1_DES1);
        btnGuardarIncialBOMBA2_DES1 = findViewById(R.id.btnGuardarIncialBOMBA2_DES1);
        btnGuardarFinalBOMBA2_DES1 = findViewById(R.id.btnGuardarFinalBOMBA2_DES1);
        btnGuardarIncialBOMBA1_DES2 = findViewById(R.id.btnGuardarIncialBOMBA1_DES2);
        btnGuardarFinalBOMBA1_DES2 = findViewById(R.id.btnGuardarFinalBOMBA1_DES2);





        //VALORES EN CAJAS DE TEXTO
        cajaGasolinaIncialBOMBA1_DES1.setText("1");
        cajaGasolinaFinalBOMBA1_DES1.setText("1");
        cajaGasolinaIncialBOMBA2_DES1.setText("2");
        cajaGasolinaFinalBOMBA2_DES1.setText("2");
        cajaGasolinaIncialBOMBA1_DES2.setText("3");
        cajaGasolinaFinalBOMBA1_DES2.setText("3");
        cajaGasolinaIncialBOMBA2_DES2.setText("4");
        cajaGasolinaFinalBOMBA2_DES2.setText("4");
        cajaGasolinaIncialBOMBA1_DES3.setText("5");
        cajaGasolinaFinalBOMBA1_DES3.setText("5");
        cajaGasolinaIncialBOMBA2_DES3.setText("6");
        cajaGasolinaFinalBOMBA2_DES3.setText("6");
        cajaGasolinaIncialBOMBA1_DES4.setText("7");
        cajaGasolinaFinalBOMBA1_DES4.setText("7");
        cajaGasolinaIncialBOMBA2_DES4.setText("8");
        cajaGasolinaFinalBOMBA2_DES4.setText("8");


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}
