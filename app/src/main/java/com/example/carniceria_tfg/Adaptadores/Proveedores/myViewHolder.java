package com.example.carniceria_tfg.Adaptadores.Proveedores;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.R;

import org.jetbrains.annotations.NotNull;

public class myViewHolder extends RecyclerView.ViewHolder {
    TextView nombreproveedor, telefono_proveedor;

    public myViewHolder(@NotNull View itemView) {
        super(itemView);
        nombreproveedor = itemView.findViewById(R.id.proveedor_nombre);
        telefono_proveedor = itemView.findViewById(R.id.telefono_proveedor);

    }

}
