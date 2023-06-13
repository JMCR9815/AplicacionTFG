package com.example.carniceria_tfg.Model;

public class Proveedor {
    private int proveedor_id;
    private String name;
    private String numero_telefono;

    public Proveedor(int proveedor_id, String name, String numero_telefono) {
        this.proveedor_id = proveedor_id;
        this.name = name;
        this.numero_telefono = numero_telefono;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    @Override
    public String toString() {
        return name;
    }


    public String toStringFull() {
        return "Proveedor{" + "proveedor_id=" + proveedor_id + ", name='" + name + '\'' + ", numero_telefono='" + numero_telefono + '\'' + '}';
    }
}
