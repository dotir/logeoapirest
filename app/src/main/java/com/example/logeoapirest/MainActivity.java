package com.example.logeoapirest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText edit_usuario,edit_pass;
    String usuario,pass,prueba;
    Usuario objusuario;
    JSONObject json = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogeo = findViewById(R.id.idIngresar);
        Logueo();
        btnLogeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobar();
            }
        });
    }

    private void Logueo() {
        final TextView textView = findViewById(R.id.textView3);
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://localhost:8080/prueba/usuario.php";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        json = null;
                        try {
                            json = new JSONObject(response);
                            objusuario = new Usuario(json);
                            textView.setText("Conectado");
                            usuario= objusuario.getUsuario();
                            pass= objusuario.getPassword();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        textView.setText("Error en la respuesta");
                    }
                }
        );


        queue.add(stringRequest);

    }


    private void comprobar(){
        edit_usuario= findViewById(R.id.idUsuario);
        edit_pass= findViewById(R.id.idPassword);

        if(edit_usuario.getText().toString().contentEquals(usuario) && edit_pass.getText().toString().contentEquals(pass)){

            Toast.makeText(this,"Bienvenido "+ objusuario.getUsuario(),Toast.LENGTH_SHORT).show();
            Intent perfil = new Intent(this,PerfilUsuario.class);
            perfil.putExtra("Usuario",objusuario);
            startActivity(perfil);
        }
        else{
            Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_SHORT).show();
        }

    }

}
