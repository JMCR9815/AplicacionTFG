package com.example.carniceria_tfg.Adaptadores.Carne;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.Model.Carne;
import com.example.carniceria_tfg.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<myViewHolder> {
    Context context;
    List<Carne> carnes;
    OnItemClickListener listener;

    public MyAdapter(Context context, List<Carne> carnes, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.carnes = carnes;
        this.listener = onItemClickListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_carne, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {

        if (carnes.get(position) != null) {
            holder.nombre_carne.setText("Tipo carne: " + carnes.get(position).getNombre());
            holder.catnidad_carne.setText("Cantidad: " + carnes.get(position).getCantidad());
            holder.fecha_entrada.setText("Fecha entrada: " + carnes.get(position).getFecha_entrada().toString());

        } else {
            holder.nombre_carne.setText("Tipo carne: " + null);
            holder.catnidad_carne.setText("Cantidad: " + null);
            holder.fecha_entrada.setText("Fecha entrada: " + null);

        }
        if (carnes.get(position).getProveedor() != null) {
            holder.proveedor.setText(String.format("Proveedor: %s", carnes.get(position).getProveedor().getNombre()));
        } else {
            holder.proveedor.setText(String.format("Proveedor: %s", (Object) null));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(carnes.get(position));
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongItemClick(carnes.get(position));
                return true;
            }
        });


    }


    @Override
    public int getItemCount() {
        return carnes.size();
    }


}
