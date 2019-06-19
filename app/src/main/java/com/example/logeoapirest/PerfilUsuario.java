package com.example.logeoapirest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilUsuario extends AppCompatActivity {



    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        Intent nu = getIntent();
        Usuario objeto = (Usuario) nu.getSerializableExtra("Usuario");

        String fotos= objeto.getFoto();
        ImageView foto = findViewById(R.id.img_usuario);
        if(fotos.contentEquals("perfil1")) {
            foto.setImageResource(R.drawable.perfil);
        }
        else if(fotos.contentEquals("perfil2")){
            foto.setImageResource(R.drawable.perfil2);
        }
        EditText nombre=findViewById(R.id.txt_nombre);
        EditText apellidos=findViewById(R.id.txt_apellido);
        EditText Edad=findViewById(R.id.txt_edad);
        final EditText password=findViewById(R.id.txt_pass);


        nombre.setText(objeto.getNombre(), TextView.BufferType.EDITABLE);
        apellidos.setText(objeto.getApellido(), TextView.BufferType.EDITABLE);
        Edad.setText(String.valueOf(objeto.getEdad()), TextView.BufferType.EDITABLE);
        password.setText(objeto.getPassword(), TextView.BufferType.EDITABLE);
        final Button btnver = findViewById(R.id.btn_ver);
        btnver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(x==0){
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    x=1;
                }
                else if (x==1){
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    x=0;
                }
            }
        });
    }


}
