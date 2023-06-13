package com.example.carniceria_tfg.Adaptadores.Productos;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.R;

import org.jetbrains.annotations.NotNull;

public class myViewHolder extends RecyclerView.ViewHolder {
    TextView nombre_producto, catnidad_producto, precio_producto, elaboracion, carne;

    public myViewHolder(@NotNull View itemView) {
        super(itemView);
        nombre_producto = itemView.findViewById(R.id.nombre_producto);
        catnidad_producto = itemView.findViewById(R.id.cantidad_producto);
        precio_producto = itemView.findViewById(R.id.precio_producto);
        elaboracion = itemView.findViewById(R.id.elaboracion);
        carne = itemView.findViewById(R.id.carne);
    }

}
