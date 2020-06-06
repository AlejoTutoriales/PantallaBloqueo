package com.alejo.g500;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alejo.g500.objetos.Constantes;
import com.alejo.g500.objetos.Usuario;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    EditText cajaUsuario;
    EditText cajaPass;
    Button btnInciarSesion;

    //ELEMENTOS PARA VOLLEY
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    boolean respuestaExistenciaUsuario;

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
                String user = cajaUsuario.getText().toString();
                String pass = cajaPass.getText().toString();
                if (Usuario.estaVacio(user, pass) == 1) {//si hay campo vacío
                    Toast.makeText(Login.this, "Algún campo vacío", Toast.LENGTH_SHORT).show();
                } else {
                    confirmarExistenciaUsuarioWebService(user, pass);
                }
            }
        });
    }

    private void inicializarElementos() {
        cajaUsuario = findViewById(R.id.cajaUsuario);
        cajaPass = findViewById(R.id.cajaPass);
        btnInciarSesion = findViewById(R.id.btnIniciarSesion);
        requestQueue = Volley.newRequestQueue(this);

    }


    public void irRegistro(View view) {
        startActivity(new Intent(Login.this, NuevoUsuario.class));
    }

    public boolean confirmarExistenciaUsuarioWebService(String usuario, String pass) {
        String url = Constantes.URL_PRINCIPAL + "buscar_u.php?user=" + usuario + "&pass=" + pass;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray json = response.optJSONArray("usuario");
                JSONObject jsonObject = null;
                try {
                    //CARGO UN OBJETO DE TIPO USUARIO Y SETEO LOS DATOS CONSUMIDOS POR EL WEBSERVICE
                    jsonObject = json.getJSONObject(0);
                    Constantes.USUARIO_LOGIN.setIdUsuario(jsonObject.optString("idUsuario"));
                    Constantes.USUARIO_LOGIN.setNombre(jsonObject.optString("nombre"));
                    Constantes.USUARIO_LOGIN.setApellido1(jsonObject.optString("apellido1"));
                    Constantes.USUARIO_LOGIN.setApellido2(jsonObject.optString("apellido2"));
                    Constantes.USUARIO_LOGIN.setUsuario(jsonObject.optString("usuario"));
                    Constantes.USUARIO_LOGIN.setPass(jsonObject.optString("pass"));
                    Constantes.USUARIO_LOGIN.setTipo_usuario(jsonObject.optString("tipo_usuario"));
                    respuestaExistenciaUsuario = true;
                    startActivity(new Intent(Login.this, MainActivity.class));
                    //MANDO UN MENSAJE DE BIENVENIDA SI SE ENCONTRÓ EL USUARIO CONCATENANDO SU NOMBRE DEL OBJETO
                    Toast.makeText(getApplicationContext(), "¡Hola " + Constantes.USUARIO_LOGIN.getNombre() + ", bienvenido!", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    btnInciarSesion.setEnabled(true);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //EN CASO DE QUE NO EXISTA
                System.out.println("Errorr : " +error.toString());
                respuestaExistenciaUsuario = false;
                Toast.makeText(getApplicationContext(), "El usuario no existe o los datos no son correctos.", Toast.LENGTH_SHORT).show();
                btnInciarSesion.setEnabled(true);
            }
        });
        requestQueue.add(jsonObjectRequest);

        //RETORNO EL VALOR FINAL
        return respuestaExistenciaUsuario;

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Login.this, MainActivity.class);
        i.putExtra("sesion", "1");
        startActivity(i);
        finish();

    }
}
