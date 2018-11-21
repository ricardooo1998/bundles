package com.tema3.ricardo.bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity{
    Button enviar;
    Button registrar;
    EditText login;
    EditText password;
    private ArrayList<Personas> per;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.nombreUsuario);
        password = findViewById(R.id.contrasenia);


        registrar = findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivityRegistro.class);
                startActivity(i);
            }
        });
        final String lo = login.getText().toString();
        final String pa = password.getText().toString();
        enviar = findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle = getIntent().getExtras();
                per = bundle.getParcelableArrayList("persona");
                for (int x=0; x<per.size(); x++)
                {
                    if (lo.equalsIgnoreCase(String.valueOf(per)))
                    {
                        if (pa.equalsIgnoreCase(String.valueOf(per)))
                        {
                            Intent i = new Intent(getApplicationContext(), Bienvenido.class);
                            startActivity(i);
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });



    }
}
