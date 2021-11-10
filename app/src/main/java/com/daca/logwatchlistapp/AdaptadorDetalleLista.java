package com.daca.logwatchlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDetalleLista extends RecyclerView.Adapter<AdaptadorDetalleLista.MyViewHolder>{

    ArrayList<Elemento> elementos = new ArrayList<>();
    Context elContextoSonLosPapas;

    public AdaptadorDetalleLista (Context ct, ArrayList<Elemento> el){
        elContextoSonLosPapas = ct;
        elementos = el;
    }

    @NonNull
    @Override
    public AdaptadorDetalleLista.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(elContextoSonLosPapas);
        View view = inflater.inflate(R.layout.my_row_detallelista, parent, false);
        return new AdaptadorDetalleLista.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDetalleLista.MyViewHolder holder, int position) {
        holder.myText1.setText(elementos.get(position).getNombre());
        holder.plataformatv.setText(elementos.get(position).getPlat());
        holder.captv.setText(String.valueOf(elementos.get(position).getCap()));
        holder.diatv.setText(elementos.get(position).getDia());
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1;
        TextView plataformatv;
        TextView diatv;
        TextView captv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.tv_categoria_lista);
            plataformatv = itemView.findViewById(R.id.tv_plataforma_detalle);
            diatv = itemView.findViewById(R.id.tv_dia_detalle);
            captv = itemView.findViewById(R.id.tv_cap_detalle);
        }
    }
}
