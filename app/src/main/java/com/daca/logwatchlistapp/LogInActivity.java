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

public class LogInActivity extends AppCompatActivity {

    private Button btnaccede;
    private EditText etEmail;
    private EditText etPass;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btnaccede = findViewById(R.id.btn_accede_logIn);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass_logIn);
        mAuth = FirebaseAuth.getInstance();

        btnaccede.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String pass = etPass.getText().toString();
            signInFun(email, pass);
        });

    }

    private void signInFun(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d("a", "signInWithEmail:success");
                            Intent miIntencion = new Intent(LogInActivity.this, ListasActivity.class);
                            miIntencion.putExtra("correo",email);
                            startActivity(miIntencion);
                        }
                        else {
                            Log.w("b", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogInActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
