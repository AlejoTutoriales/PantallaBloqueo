package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.alejo.g500.objetos.Constantes;
import com.alejo.g500.objetos.Lectura;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Reportes extends AppCompatActivity {
    List<Lectura> LECTURAS = new ArrayList<>();

    ListView listaLecturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaLecturas = findViewById(R.id.listaRegistroBombas);

        poblarListaLecturas(Constantes.USUARIO_LOGIN.getIdUsuario());
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }


    private void poblarListaLecturas(String idUsuario) {
        //Crear un objeto requetqueue
        RequestQueue requestQueue = Volley.newRequestQueue(Reportes.this);
        //Url del webservice
        String url = Constantes.URL_PRINCIPAL + "mostrar_lecturas.php?id=" + idUsuario;
        System.out.println("URL A EJERCUTARSE: " + url);
        // crear un objeto requet
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray json = response.getJSONArray("lecturas");
                    JSONObject jsonObject = null;

                    LECTURAS.clear();
                    for (int i = 0; i < json.length(); i++) {
                        jsonObject = json.getJSONObject(i);


                        String idRegistro = jsonObject.optString("idRegistro");
                        String num_bomba = jsonObject.optString("num_bomba");
                        String valor_incial = jsonObject.optString("valor_incial");
                        String valor_final = jsonObject.optString("valor_final");
                        String idUsuario = jsonObject.optString("idUsuario");
                        String num_despachador = jsonObject.optString("num_despachador");
                        String tipo_gasolina = jsonObject.optString("tipo_gasolina");
                        String fecha = jsonObject.optString("fecha");

                        LECTURAS.add(new Lectura(idRegistro, num_bomba, valor_incial, valor_final, idUsuario, num_despachador, tipo_gasolina, fecha));
                    }

                    ArrayAdapter<Lectura> adaptador = new ArrayAdapter<>(Reportes.this, android.R.layout.simple_list_item_1, LECTURAS);
                    listaLecturas.setAdapter(adaptador);


                } catch (Exception e) {
                    Toast.makeText(Reportes.this, "Se produjo un problema a la hora de cargar las lecturas, intente más tarde...", Toast.LENGTH_LONG).show();
                    System.out.println("ERROR: " + e.toString());

                }

            }
        }, new Response.ErrorListener() {
            @Override


            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Reportes.this, "Se produjo un problema a la hora de cargar las lecturas, intente más tarde...", Toast.LENGTH_LONG).show();
                System.out.println("ERROR: " + error.toString());

            }
        });

        requestQueue.add(jsonObjectRequest);


    }
}
