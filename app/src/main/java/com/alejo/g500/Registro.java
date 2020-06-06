package com.alejo.g500;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alejo.g500.objetos.Constantes;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText gasolinaInicialB1D1, gasolinaFinalB1D1;
    EditText gasolinaInicialB1D1P, gasolinaFinalB1D1P;

    EditText gasolinaInicialB2D1, gasolinaFinalB2D1;
    EditText gasolinaInicialB2D1P, gasolinaFinalB2D1P;

    EditText gasolinaInicialB1D2, gasolinaFinalB1D2;
    EditText gasolinaInicialB1D2P, gasolinaFinalB1D2P;

    EditText gasolinaInicialB2D2, gasolinaFinalB2D2;
    EditText gasolinaInicialB2D2P, gasolinaFinalB2D2P;


    Button btnGuardarIncialBOMBA1_DES1, btnGuardarFinalBOMBA1_DES1;
    Button btnGuardarIncialBOMBA2_DES1P, btnGuardarFinalBOMBA2_DES1P;

    Button btnGuardarIncialBOMBA1_DES2, btnGuardarFinalBOMBA1_DES2;
    Button btnGuardarIncialBOMBA2_DES2P, btnGuardarFinalBOMBA2_DES2P;

    Button btnGuardarIncialBOMBA1_DES1P, btnGuardarFinalBOMBA1_DES1P;
    Button btnGuardarIncialBOMBA2_DES1, btnGuardarFinalBOMBA2_DES1;

    Button btnGuardarIncialBOMBA1_DES2P, btnGuardarFinalBOMBA1_DES2P;
    Button btnGuardarIncialBOMBA2_DES2, btnGuardarFinalBOMBA2_DES2;

    RequestQueue requestQueue;

    StringRequest stringRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inicializarElementos();
        clicks();


    }

    private void clicks() {

        btnGuardarIncialBOMBA1_DES1.setOnClickListener(this);
        btnGuardarFinalBOMBA1_DES1.setOnClickListener(this);
        btnGuardarIncialBOMBA2_DES1P.setOnClickListener(this);
        btnGuardarFinalBOMBA2_DES1P.setOnClickListener(this);

        btnGuardarIncialBOMBA1_DES2.setOnClickListener(this);
        btnGuardarFinalBOMBA1_DES2.setOnClickListener(this);
        btnGuardarIncialBOMBA2_DES2P.setOnClickListener(this);
        btnGuardarFinalBOMBA2_DES2P.setOnClickListener(this);

        btnGuardarIncialBOMBA1_DES1P.setOnClickListener(this);
        btnGuardarFinalBOMBA1_DES1P.setOnClickListener(this);
        btnGuardarIncialBOMBA2_DES1.setOnClickListener(this);
        btnGuardarFinalBOMBA2_DES1.setOnClickListener(this);

        btnGuardarIncialBOMBA1_DES2P.setOnClickListener(this);
        btnGuardarFinalBOMBA1_DES2P.setOnClickListener(this);
        btnGuardarIncialBOMBA2_DES2.setOnClickListener(this);
        btnGuardarFinalBOMBA2_DES2.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        String fechaHoy = "06/06/2020";

        switch (v.getId()) {
            //BOMBA 1
            case R.id.btnGuardarIncialBOMBA1_DES1:

                String valorInicialBOMBA1_DES1 = gasolinaInicialB1D1.getText().toString();
                enviarRegistro(1, valorInicialBOMBA1_DES1, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA1_DES1:

                String valorFinalBOMBA1_DES1 = gasolinaFinalB1D1.getText().toString();
                actualizarValorFinal(1, valorFinalBOMBA1_DES1, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;


            case R.id.btnGuardarIncialBOMBA1_DES1P:

                String valorInicialBOMBA1_DES1P = gasolinaInicialB1D1P.getText().toString();
                enviarRegistro(1, valorInicialBOMBA1_DES1P, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA1_DES1P:

                String valorFinalFinalBOMBA1_DES1P = gasolinaFinalB1D1P.getText().toString();
                actualizarValorFinal(1, valorFinalFinalBOMBA1_DES1P, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;

            //BOMBA 2

            case R.id.btnGuardarIncialBOMBA2_DES1:

                String valorInicialBOMBA2_DES1 = gasolinaInicialB2D1.getText().toString();
                enviarRegistro(2, valorInicialBOMBA2_DES1, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA2_DES1:

                String valorFinalBOMBA2_DES1 = gasolinaFinalB2D1.getText().toString();
                actualizarValorFinal(2, valorFinalBOMBA2_DES1, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;


            case R.id.btnGuardarIncialBOMBA2_DES1P:

                String valorInicialBOMBA2_DES1P = gasolinaInicialB2D1P.getText().toString();
                enviarRegistro(2, valorInicialBOMBA2_DES1P, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA2_DES1P:

                String valorFinalFinalBOMBA2_DES1P = gasolinaFinalB2D1P.getText().toString();
                actualizarValorFinal(2, valorFinalFinalBOMBA2_DES1P, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;


            //BOMBA 3
            case R.id.btnGuardarIncialBOMBA1_DES2:

                String valorInicialBOMBA1_DES2 = gasolinaInicialB1D2.getText().toString();
                enviarRegistro(3, valorInicialBOMBA1_DES2, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA1_DES2:

                String valorFinalBOMBA1_DES2 = gasolinaFinalB1D2.getText().toString();
                actualizarValorFinal(3, valorFinalBOMBA1_DES2, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;


            case R.id.btnGuardarIncialBOMBA1_DES2P:

                String valorInicialBOMBA1_DES2P = gasolinaInicialB1D2P.getText().toString();
                enviarRegistro(3, valorInicialBOMBA1_DES2P, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA1_DES2P:

                String valorFinalFinalBOMBA1_DES2P = gasolinaFinalB1D2P.getText().toString();
                actualizarValorFinal(3, valorFinalFinalBOMBA1_DES2P, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;

            //BOMBA 4

            case R.id.btnGuardarIncialBOMBA2_DES2:

                String valorInicialBOMBA2_DES2 = gasolinaInicialB2D2.getText().toString();
                enviarRegistro(4, valorInicialBOMBA2_DES2, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA2_DES2:

                String valorFinalBOMBA2_DES2 = gasolinaFinalB2D2.getText().toString();
                actualizarValorFinal(4, valorFinalBOMBA2_DES2, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 0, fechaHoy);

                break;


            case R.id.btnGuardarIncialBOMBA2_DES2P:

                String valorInicialBOMBA2_DES2P = gasolinaInicialB2D2P.getText().toString();
                enviarRegistro(4, valorInicialBOMBA2_DES2P, 0, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;

            case R.id.btnGuardarFinalBOMBA2_DES2P:

                String valorFinalFinalBOMBA2_DES2P = gasolinaFinalB2D2P.getText().toString();
                actualizarValorFinal(4, valorFinalFinalBOMBA2_DES2P, Constantes.USUARIO_LOGIN.getIdUsuario(), 1, 1, fechaHoy);

                break;


        }

    }

    private void actualizarValorFinal(int numBomba, String valorFinal, String idUsuario, int numDespachador, int tipoGasolina, String fecha) {

        String url = Constantes.URL_PRINCIPAL + "actualizar_lectura.php?numBomba=" + numBomba + "&valorFinal=" + valorFinal + "&idUsuario=" + idUsuario + "&numDespachador=" + numDespachador + "&tipoGasolina=" + tipoGasolina + "&fecha=" + fecha;
        System.out.println("URL A EJECUTAR_ " + url);
        stringRequest = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Registro.this, "Lectura almacenada con éxito", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registro.this, "Se ha producido un error, intente más tarde...", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }

    private void enviarRegistro(int numBomba, String valorInicial, int valorFinal, String idUsuario, int numDespachador, int tipoGasolina, String fecha) {

        String url = Constantes.URL_PRINCIPAL + "insertar_lectura.php?numBomba=" + numBomba + "&valorInicial=" + valorInicial + "&valorFinal=" + valorFinal + "&idUsuario=" + idUsuario + "&numDespachador=" + numDespachador + "&tipoGasolina=" + tipoGasolina + "&fecha=" + fecha;
        stringRequest = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Registro.this, "Lectura almacenada con éxito", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registro.this, "Se ha producido un error, intente más tarde...", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);

    }

    private void inicializarElementos() {
        requestQueue = Volley.newRequestQueue(this);

        //CAJAS DE TEXTO
        //B1
        gasolinaInicialB1D1 = findViewById(R.id.gasolinaInicialB1D1);
        gasolinaFinalB1D1 = findViewById(R.id.gasolinaFinalB1D1);
        gasolinaInicialB1D1P = findViewById(R.id.gasolinaInicialB1D1P);
        gasolinaFinalB1D1P = findViewById(R.id.gasolinaFinalB1D1P);

        //B2
        gasolinaInicialB2D1 = findViewById(R.id.gasolinaInicialB2D1);
        gasolinaFinalB2D1 = findViewById(R.id.gasolinaFinalB2D1);
        gasolinaInicialB2D1P = findViewById(R.id.gasolinaInicialB2D1P);
        gasolinaFinalB2D1P = findViewById(R.id.gasolinaFinalB2D1P);

        //B3
        gasolinaInicialB1D2 = findViewById(R.id.gasolinaInicialB1D2);
        gasolinaFinalB1D2 = findViewById(R.id.gasolinaFinalB1D2);
        gasolinaInicialB1D2P = findViewById(R.id.gasolinaInicialB1D2P);
        gasolinaFinalB1D2P = findViewById(R.id.gasolinaFinalB1D2P);

        //B4
        gasolinaInicialB2D2 = findViewById(R.id.gasolinaInicialB2D2);
        gasolinaFinalB2D2 = findViewById(R.id.gasolinaFinalB2D2);
        gasolinaInicialB2D2P = findViewById(R.id.gasolinaInicialB2D2P);
        gasolinaFinalB2D2P = findViewById(R.id.gasolinaFinalB2D2P);


        //BOTONES

        //B1
        btnGuardarIncialBOMBA1_DES1 = findViewById(R.id.btnGuardarIncialBOMBA1_DES1);
        btnGuardarFinalBOMBA1_DES1 = findViewById(R.id.btnGuardarFinalBOMBA1_DES1);
        btnGuardarIncialBOMBA1_DES1P = findViewById(R.id.btnGuardarIncialBOMBA1_DES1P);
        btnGuardarFinalBOMBA1_DES1P = findViewById(R.id.btnGuardarFinalBOMBA1_DES1P);

        //B2
        btnGuardarIncialBOMBA2_DES1 = findViewById(R.id.btnGuardarIncialBOMBA2_DES1);
        btnGuardarFinalBOMBA2_DES1 = findViewById(R.id.btnGuardarFinalBOMBA2_DES1);
        btnGuardarIncialBOMBA2_DES1P = findViewById(R.id.btnGuardarIncialBOMBA2_DES1P);
        btnGuardarFinalBOMBA2_DES1P = findViewById(R.id.btnGuardarFinalBOMBA2_DES1P);

        //B3
        btnGuardarIncialBOMBA1_DES2 = findViewById(R.id.btnGuardarIncialBOMBA1_DES2);
        btnGuardarFinalBOMBA1_DES2 = findViewById(R.id.btnGuardarFinalBOMBA1_DES2);
        btnGuardarIncialBOMBA1_DES2P = findViewById(R.id.btnGuardarIncialBOMBA1_DES2P);
        btnGuardarFinalBOMBA1_DES2P = findViewById(R.id.btnGuardarFinalBOMBA1_DES2P);

        //B4
        btnGuardarIncialBOMBA2_DES2 = findViewById(R.id.btnGuardarIncialBOMBA2_DES2);
        btnGuardarFinalBOMBA2_DES2 = findViewById(R.id.btnGuardarFinalBOMBA2_DES2);
        btnGuardarIncialBOMBA2_DES2P = findViewById(R.id.btnGuardarIncialBOMBA2_DES2P);
        btnGuardarFinalBOMBA2_DES2P = findViewById(R.id.btnGuardarFinalBOMBA2_DES2P);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }


}
