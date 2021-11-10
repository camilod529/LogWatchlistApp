package com.daca.logwatchlistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    EditText etCorreo;
    EditText etPass;
    Button btncrear;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        etCorreo = findViewById(R.id.etEmail_signin);
        etPass = findViewById(R.id.etPass_signin);
        btncrear = findViewById(R.id.btn_crear_signin);

        btncrear.setOnClickListener(view -> {
            String email = etCorreo.getText().toString();
            String pass = etPass.getText().toString();
            createAccount(email,pass);
        });


    }

    private void createAccount(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d("a", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent miIntencion = new Intent(SignInActivity.this, ListasActivity.class);
                            miIntencion.putExtra("correo",email);
                            startActivity(miIntencion);
                        }
                        else {
                            Log.w("b", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}