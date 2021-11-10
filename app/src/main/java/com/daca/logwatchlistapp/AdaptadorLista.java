package com.daca.logwatchlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.MyViewHolder> {

    String datos[];
    Context elContextoSonLosPapas;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(datos[position]);
    }

    @Override
    public int getItemCount() {
        return datos.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.tv_categoria_lista);
        }
    }
}
