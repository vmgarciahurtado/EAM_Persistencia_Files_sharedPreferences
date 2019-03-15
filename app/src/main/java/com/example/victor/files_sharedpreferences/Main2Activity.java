package com.example.victor.files_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {

    TextView txtNombre,txtApellido,txtEdad;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hola grupo
        setContentView(R.layout.activity_main2);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEdad = findViewById(R.id.txtEdad);
        cargarDatos();

    }


    private void cargarDatos() {
        preferences = Objects.requireNonNull(getApplicationContext().getSharedPreferences("usuario", Context.MODE_PRIVATE));
        txtNombre.setText("Nombre: " + preferences.getString("nombre", "No existe el valor"));
        txtApellido.setText("Apellido: " + preferences.getString("apellido", "No existe el valor"));
        txtEdad.setText("Edad: " + preferences.getString("edad", "No existe el valor"));
        Toast.makeText(this, "Edad: " + preferences.getString("edad", "No existe el valor"), Toast.LENGTH_SHORT).show();
    }
}
