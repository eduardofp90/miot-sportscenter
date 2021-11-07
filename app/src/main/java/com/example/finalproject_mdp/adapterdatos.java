package com.example.finalproject_mdp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterdatos extends RecyclerView.Adapter<adapterdatos.ViewHolderDatos> {

    //recibe lista para mostrar en el recycler
    ArrayList<String> listDatos;
    ArrayList<String> listSchedules;
    Context context;

    //constructor
    public adapterdatos(Context context, ArrayList<String> listDatos,ArrayList<String> listSchedules) {
        this.context = context;
        this.listDatos = listDatos;
        this.listSchedules = listSchedules;

    }

    //enlazar adaptador con itemlist
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,null,false);
        return new ViewHolderDatos(view);
    }

    //establecer la comunicacion entre el adaptador y la clase ViewHolderDatos
    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        //set the data in items
        holder.tvDatos.setText(listDatos.get(position));
        holder.tvschedules.setText(listSchedules.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    //mostrar datos
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tvDatos;
        TextView tvschedules;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            tvDatos = itemView.findViewById(R.id.tv_id_items);
            tvschedules = itemView.findViewById(R.id.tv_id_items2);
        }
    }
}
