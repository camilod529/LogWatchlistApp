package com.daca.logwatchlistapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.MyViewHolder> {

    String datos[];
    Context elContextoSonLosPapas;
    AdaptadorLista.OnItemClickListener onItemClickListener;

    public AdaptadorLista (Context ct, String nombres[]){
        elContextoSonLosPapas = ct;
        datos = nombres;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(elContextoSonLosPapas);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.myText1.setText(datos[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(elContextoSonLosPapas, DetalleListaActivity.class);
                intent.putExtra("categoria", datos[position]);
                elContextoSonLosPapas.startActivity(intent);
            }
        });

    }

    public interface OnItemClickListener{
        void OnItemClick(Elemento elemento);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return datos.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.tv_categoria_lista);
            mainLayout = itemView.findViewById(R.id.mainLayout_listas);
        }
    }
}
