package com.daca.logwatchlistapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DetalleListaActivity extends AppCompatActivity {

    private ArrayList<Elemento> elementos = new ArrayList<>();
    private RecyclerView rvListasDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_lista);

        final String categoria = getIntent().getStringExtra("categoria");

        rvListasDetalle = findViewById(R.id.rv_listas_elementos_detallelista);
        final FirebaseFirestore elementosFirestore = FirebaseFirestore.getInstance();

        elementosFirestore.collection("Elementos").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                for (DocumentSnapshot miDocumento: value.getDocuments())
                {
                    Elemento elemento = miDocumento.toObject(Elemento.class);
                    elemento.setId(miDocumento.getId());
                    Log.d("elemento", elemento.getNombre());
                    //System.out.println(elemento.getNombre());
                    //if(elemento.getCategoria().equals(categoria))
                    //{
                        elementos.add(elemento);
                    //}
                    Log.d("error", String.valueOf(error));

                }

            }
        });

        AdaptadorDetalleLista adapter = new AdaptadorDetalleLista(this, elementos);
        rvListasDetalle.setAdapter(adapter);
        rvListasDetalle.setLayoutManager(new LinearLayoutManager(this));
    }
}