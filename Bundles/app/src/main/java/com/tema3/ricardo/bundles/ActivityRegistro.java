package com.tema3.ricardo.bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityRegistro extends AppCompatActivity{
    ArrayList<Personas> persona;
    EditText userId;
    EditText nombre;
    EditText apellidos;
    EditText email;
    EditText contrasenia;
    EditText telefono;
    Button registrar;
    Button cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        persona = new ArrayList<Personas>();
        userId = findViewById(R.id.userId);
        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        email = findViewById(R.id.email);
        contrasenia = findViewById(R.id.password);
        telefono = findViewById(R.id.telefono);
        registrar = findViewById(R.id.registrarUsuario);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persona.add(new Personas(userId.getText().toString(), nombre.getText().toString(), apellidos.getText().toString(), email.getText().toString(), contrasenia.getText().toString(), telefono.getText().toString()));
                Toast.makeText(getApplicationContext(), "Se ha insertado:"+nombre.getText().toString(), Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("persona", persona);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        cancelar = findViewById(R.id.cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }
}
