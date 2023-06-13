package com.example.carniceria_tfg.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Carne {
    @SerializedName("carne_id")
    @Expose
    private int carne_id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("proveedor")
    @Expose
    private Proveedor proveedor;
    @SerializedName("catidad")
    @Expose
    private int catidad;
    @SerializedName("fecha_entrada")
    @Expose
    private String fecha_entrada;

    public Carne(int carne_id, String nombre, Proveedor proveedor, int catidad, String fecha_entrada) {
        this.carne_id = carne_id;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.catidad = catidad;
        this.fecha_entrada = fecha_entrada;
    }

    public Carne(String nombre, Proveedor proveedor, int catidad, String fecha_entrada) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.catidad = catidad;
        this.fecha_entrada = fecha_entrada;
    }

    public int getCarne_id() {
        return carne_id;
    }

    public void setCarne_id(int carne_id) {
        this.carne_id = carne_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return catidad;
    }

    public void setCantidad(int cantidad) {
        this.catidad = cantidad;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }


    @Override
    public String toString() {
        return nombre;
    }

    public String toStringFull() {
        return "Carne{" + "nombre='" + nombre + '\'' + ", proveedor=" + proveedor + ", catidad=" + catidad + ", fecha_entrada='" + fecha_entrada + '\'' + '}';
    }
}
