package com.example.carniceria_tfg.Adaptadores.Productos;

import com.example.carniceria_tfg.Model.Productos;

public interface OnItemClickListener {
    void onItemClick(Productos item);

    void onLongItemClick(Productos item);
}
