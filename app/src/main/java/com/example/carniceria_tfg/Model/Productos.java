package com.example.carniceria_tfg.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Productos {
    @SerializedName("producto_id")
    @Expose
    private int productos_id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("precio")
    @Expose
    private int precio;
    @SerializedName("cantidad")
    @Expose
    private int cantidad;
    @SerializedName("disponibilidad")
    @Expose
    private boolean disponibilidad;
    @SerializedName("elaboraciones")
    @Expose
    private Elaboracion elaboraciones;
    @SerializedName("carne")
    @Expose
    private Carne carne;


    public Productos(int productos_id, String nombre, String descripcion, int precio, int cantidad, boolean disponibilidad) {
        this.productos_id = productos_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
    }

    public Productos(int productos_id, String nombre, String descripcion, int precio, int cantidad, boolean disponibilidad, Carne carne) {
        this.productos_id = productos_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.carne = carne;
    }

    public Productos(int productos_id, String nombre, String descripcion, int precio, int cantidad, boolean disponibilidad, Elaboracion elaboraciones, Carne carne) {
        this.productos_id = productos_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.elaboraciones = elaboraciones;
        this.carne = carne;

    }

    public Productos(String nombre, String descripcion, int precio, int cantidad, boolean disponibilidad, Elaboracion elaboraciones, Carne carne) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
        this.elaboraciones = elaboraciones;
        this.carne = carne;

    }

    public int getProductos_id() {
        return productos_id;
    }

    public void setProductos_id(int productos_id) {
        this.productos_id = productos_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Elaboracion getElaboracion() {
        return elaboraciones;
    }

    public void setElaboracion(Elaboracion elaboracion) {
        this.elaboraciones = elaboracion;
    }

    public Carne getCarne() {
        return carne;
    }

    public void setCarne(Carne carne) {
        this.carne = carne;
    }
}
