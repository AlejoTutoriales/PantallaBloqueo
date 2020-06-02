package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.alejo.g500.objetos.Constantes;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class NuevoUsuario extends AppCompatActivity {
    private Spinner spnTiposCargos;
    private Button btnRegistrarUsuario;
    private EditText nombre, apellido1, apellido2, usuario, pass;
    private int tipoCargoSeleccionado;
    RequestQueue requestQueue;

    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registrar nuevo usuario");

        inicializarElementos();
        poblarSpinnerCargos();
        validarSpinner();

        clicks();
    }

    private void clicks() {
        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreIngresado = nombre.getText().toString();
                String apellido1Ingresado = apellido1.getText().toString();
                String apellido2Ingresado = apellido2.getText().toString();
                String usuarioIngresado = usuario.getText().toString();
                String passIngresada = pass.getText().toString();


                if (nombreIngresado.isEmpty() || apellido1Ingresado.isEmpty() || apellido2Ingresado.isEmpty() || usuarioIngresado.isEmpty() || passIngresada.isEmpty()) {
                    Toast.makeText(NuevoUsuario.this, "Algún campo vacío", Toast.LENGTH_SHORT).show();
                } else {
                    if (tipoCargoSeleccionado == 0) {
                        Toast.makeText(NuevoUsuario.this, "Seleccione un tipo de cargo válido", Toast.LENGTH_SHORT).show();
                    } else {
                        registrarUsuario(nombreIngresado, apellido1Ingresado, apellido2Ingresado, usuarioIngresado, passIngresada, tipoCargoSeleccionado);
                        limpiarCampos();
                    }

                }


            }
        });
    }

    private void registrarUsuario(String nombreIngresado, String apellido1Ingresado, String apellido2Ingresado, String usuarioIngresado, String passIngresada, int tipoCargoSeleccionado) {
        String url = Constantes.URL_PRINCIPAL + "insertar_usuario.php?nombre=" + nombreIngresado + "&apellido1=" + apellido1Ingresado + "&apellido2=" + apellido2Ingresado + "&user=" + usuarioIngresado + "&pass=" + passIngresada + "&tipo=" + tipoCargoSeleccionado;
        stringRequest = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(NuevoUsuario.this, "¡Usuario registrado exitosamente!", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(NuevoUsuario.this, Login.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NuevoUsuario.this, "Se ha producid un error, intente más tarde...", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }

    private void limpiarCampos() {
        nombre.setText("");
        apellido1.setText("");
        apellido2.setText("");
        usuario.setText("");
        pass.setText("");
        spnTiposCargos.setSelection(0);

    }

    private void validarSpinner() {
        spnTiposCargos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (pos != 0) {
                    if (pos == 1) {//despachador
                        tipoCargoSeleccionado = 1;
                    } else if (pos == 2) {//gerente
                        tipoCargoSeleccionado = 2;
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    private void poblarSpinnerCargos() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(NuevoUsuario.this,
                R.array.tiposCargos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTiposCargos.setAdapter(adapter);
    }

    private void inicializarElementos() {
        spnTiposCargos = findViewById(R.id.spnTipoCargos);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarse);
        nombre = findViewById(R.id.cajaNombre);
        apellido1 = findViewById(R.id.cajaApellido1);
        apellido2 = findViewById(R.id.cajaApellido2);
        pass = findViewById(R.id.cajaPass);
        requestQueue = Volley.newRequestQueue(this);
        usuario = findViewById(R.id.cajaUsuario);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}
