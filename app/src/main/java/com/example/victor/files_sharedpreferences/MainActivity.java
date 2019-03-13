package com.example.victor.files_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText campoNombre,campoEdad,campoApellido;
    SharedPreferences preferences;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoNombre = findViewById(R.id.campoNombre);
        campoEdad = findViewById(R.id.campoEdad);
        campoApellido = findViewById(R.id.campoApellido);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = getSharedPreferences("usuario", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("nombre",campoNombre.getText().toString());
                editor.putString("apellido",campoApellido.getText().toString());
                editor.putString("edad",campoEdad.getText().toString());
                editor.commit();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }

}
