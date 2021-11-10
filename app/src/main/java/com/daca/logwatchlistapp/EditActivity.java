package com.daca.logwatchlistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditActivity extends AppCompatActivity {

    Spinner spinner;
    EditText nombreEt, plataformaEt, capitulosEt;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        final Elemento elemento = (Elemento) getIntent().getSerializableExtra("elemento");

        Log.d("elemento", elemento.getNombre());

        nombreEt = findViewById(R.id.et_nombre_edit);
        plataformaEt = findViewById(R.id.et_plataforma_edit);
        capitulosEt = findViewById(R.id.et_capitulos_edit);

        nombreEt.setText(elemento.getNombre());
        plataformaEt.setText(elemento.getPlat());
        capitulosEt.setText(elemento.getCap());
        fab = findViewById(R.id.floatingActionButton_edit);

        spinner = (Spinner) findViewById(R.id.spinner_dias_edit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dias_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        if(elemento.getDia() != null)
        {
            int spinnerIndex = adapter.getPosition(elemento.getDia());
            spinner.setSelection(spinnerIndex);
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nombreEt.getText().toString();
                String plat = plataformaEt.getText().toString();
                String cap = capitulosEt.getText().toString();
                String dia = spinner.getSelectedItem().toString();

                Elemento aux = new Elemento(elemento.getId(), nombre, plat, cap, dia, elemento.getCategoria());

                firestore.collection("Elementos").document(elemento.getId()).set(aux).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Log.d("firebase", "actualizado");
                            finish();
                        }
                    }
                });

            }
        });



    }
}