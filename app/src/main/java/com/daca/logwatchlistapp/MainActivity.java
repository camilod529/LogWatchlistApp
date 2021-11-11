package com.daca.logwatchlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnLogIn;
    private TextView tvCrearC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogIn = findViewById(R.id.btnMainLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirLogIn();
            }
        });

        tvCrearC = findViewById(R.id.txtMainCuenta);
        tvCrearC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirSignIn();
            }
        });

    }

    public void abrirLogIn(){
        Intent intentLogIn = new Intent(this, LogInActivity.class);
        startActivity(intentLogIn);
        finish();
    }

    public void abrirSignIn(){
        Intent intentSignIn = new Intent(this, SignInActivity.class);
        startActivity(intentSignIn);
    }
}