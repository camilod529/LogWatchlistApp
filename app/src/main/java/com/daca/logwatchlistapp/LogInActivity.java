package com.daca.logwatchlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private Button btnaccede;
    private EditText etEmail;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btnaccede = findViewById(R.id.btn_accede_logIn);
        etEmail = findViewById(R.id.etEmail_logIn);
        etPass = findViewById(R.id.etPass_logIn);

        btnaccede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usu = "prueba@correo.com";
                String pass = "prueba123";
                String correo = etEmail.getText().toString();
                String passwd = etPass.getText().toString();

                if(correo.equals(usu) && passwd.equals(pass)){
                    Toast.makeText(LogInActivity.this, "Bienvenido " + correo, Toast.LENGTH_LONG).show();

                    Intent miIntencion = new Intent(LogInActivity.this, ListasActivity.class);
                    miIntencion.putExtra("correo",correo);
                    startActivity(miIntencion);
                    finish();
                } else{
                    Toast.makeText(LogInActivity.this, "Datos errados", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}