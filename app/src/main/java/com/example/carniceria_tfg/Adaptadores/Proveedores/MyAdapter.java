package com.example.carniceria_tfg.Adaptadores.Proveedores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.Model.Proveedor;
import com.example.carniceria_tfg.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<myViewHolder> {
    Context context;
    List<Proveedor> proveedores;
    OnItemClickListener listener;

    public MyAdapter(Context context, List<Proveedor> proveedores, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.proveedores = proveedores;
        this.listener = onItemClickListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_proveedores, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (proveedores.get(position) != null) {
            holder.nombreproveedor.setText(String.format("Nombre: %s", proveedores.get(position).getNombre()));
        } else holder.nombreproveedor.setText("Nombre: " + null);

        if (proveedores.get(position) != null) {
            holder.telefono_proveedor.setText(String.format("Telefono: %s", proveedores.get(position).getNumero_telefono()));
        } else holder.telefono_proveedor.setText("Telefono: " + null);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(proveedores.get(position));
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongItemClick(proveedores.get(position));
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return proveedores.size();
    }


}
