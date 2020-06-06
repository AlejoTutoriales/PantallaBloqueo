package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfiguracionGasolina extends AppCompatActivity implements View.OnClickListener {
    private EditText cajaCostoSuper, cajaCostoPremium;
    private Button btnCostoSuper, btnCostoPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_gasolina);
        getSupportActionBar().setTitle("Configuración de precios");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        inicializarElmentos();
        clicks();

    }

    private void clicks() {
        btnCostoSuper.setOnClickListener(this);
        btnCostoPremium.setOnClickListener(this);
    }

    private void inicializarElmentos() {
        cajaCostoPremium = findViewById(R.id.cajaCostoPremium);
        cajaCostoSuper = findViewById(R.id.cajaCostoSuper);
        btnCostoPremium = findViewById(R.id.btnCostoPremium);
        btnCostoSuper = findViewById(R.id.btnCostoSuper);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnCostoSuper:
                Toast.makeText(this, "¡Costo actualizado!", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnCostoPremium:
                Toast.makeText(this, "¡Costo actualizado!", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
