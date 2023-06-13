package com.example.carniceria_tfg.Adaptadores.Elaboraciones;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.Model.Elaboracion;
import com.example.carniceria_tfg.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<myViewHolder> {
    Context context;
    List<Elaboracion> elaboraciones;
    OnItemClickListener listener;

    public MyAdapter(Context context, List<Elaboracion> elaboraciones, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.elaboraciones = elaboraciones;
        this.listener = onItemClickListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_elaboraciones, parent, false));
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (elaboraciones.get(position) != null) {
            holder.nombre_elaboracion.setText("Nombre: " + elaboraciones.get(position).getNombre());
            holder.semana_elaboracion.setText("Codigo elaboracion: " + elaboraciones.get(position).getSemanaElaboracion());
            holder.cantidad_elaborada.setText("Cantidad elaborada: " + elaboraciones.get(position).getCantidadElaborada());

            holder.ingredientes_elaboracion.setText("Ingredientes: " + elaboraciones.get(position).getIngredientes());
        } else {
            holder.nombre_elaboracion.setText("Nombre: " + null);
            holder.semana_elaboracion.setText("Codigo elaboracion: " + null);
            holder.cantidad_elaborada.setText("Cantidad elaborada: " + null);

            holder.ingredientes_elaboracion.setText("Ingredientes: " + null);
        }
        if (elaboraciones.get(position).getCarne() != null) {
            holder.carne_elaboracion.setText("Carne: " + elaboraciones.get(position).getCarne().getNombre());
        } else {
            holder.carne_elaboracion.setText("Carne: " + null);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(elaboraciones.get(position));
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongItemClick(elaboraciones.get(position));
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return elaboraciones.size();
    }


}
