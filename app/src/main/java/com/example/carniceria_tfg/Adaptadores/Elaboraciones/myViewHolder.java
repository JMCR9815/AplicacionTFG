package com.example.carniceria_tfg.Adaptadores.Elaboraciones;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.R;

import org.jetbrains.annotations.NotNull;

public class myViewHolder extends RecyclerView.ViewHolder {
    TextView nombre_elaboracion, semana_elaboracion, cantidad_elaborada, carne_elaboracion, ingredientes_elaboracion;

    public myViewHolder(@NotNull View itemView) {
        super(itemView);
        nombre_elaboracion = itemView.findViewById(R.id.nombre_elaboracion);
        semana_elaboracion = itemView.findViewById(R.id.semana_elaboracion);
        cantidad_elaborada = itemView.findViewById(R.id.cantidad_elaboracion);
        carne_elaboracion = itemView.findViewById(R.id.carne_elaboracion);
        ingredientes_elaboracion = itemView.findViewById(R.id.ingredientes_elaboracion);
    }

}
