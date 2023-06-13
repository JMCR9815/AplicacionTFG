package com.example.carniceria_tfg.Adaptadores.Productos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.Model.Productos;
import com.example.carniceria_tfg.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<myViewHolder> {
    Context context;
    List<Productos> productos;
    OnItemClickListener listener;

    public MyAdapter(Context context, List<Productos> productos, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.productos = productos;
        this.listener = onItemClickListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_productos, parent, false));
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (productos.get(position) != null) {
            holder.nombre_producto.setText(String.format("Nombre: %s", productos.get(position).getNombre()));
            holder.catnidad_producto.setText(String.format("Cantidad: %d", productos.get(position).getCantidad()));
            holder.precio_producto.setText(String.format("Precio : %d", productos.get(position).getPrecio()));
        } else {
            holder.nombre_producto.setText("Nombre: " + null);
            holder.catnidad_producto.setText("Cantidad: " + null);
            holder.precio_producto.setText("Precio: " + null);
        }

        if (productos.get(position).getElaboracion() != null) {
            holder.elaboracion.setText(String.format("Elaboracion: %s", productos.get(position).getElaboracion().getCodigo()));
        } else {
            holder.elaboracion.setText(String.format("Elaboracion: %s", null));
        }

        if (productos.get(position).getCarne() != null) {
            holder.carne.setText(String.format("Carne: %s", productos.get(position).getCarne().getNombre()));
        } else {
            holder.carne.setText(String.format("Carne: %s", null));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(productos.get(position));
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongItemClick(productos.get(position));
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return productos.size();
    }


}
