package com.example.carniceria_tfg.Adaptadores.Carne;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.R;

import org.jetbrains.annotations.NotNull;

public class myViewHolder extends RecyclerView.ViewHolder {
    TextView nombre_carne, catnidad_carne, fecha_entrada, proveedor;
    CardView cardView;

    public myViewHolder(@NotNull View itemView) {
        super(itemView);
        nombre_carne = itemView.findViewById(R.id.carne_nombre);
        catnidad_carne = itemView.findViewById(R.id.cantidad_carne);
        fecha_entrada = itemView.findViewById(R.id.fecha_entrada);
        proveedor = itemView.findViewById(R.id.provedor);

    }


}
