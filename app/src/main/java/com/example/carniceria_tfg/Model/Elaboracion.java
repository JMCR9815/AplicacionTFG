package com.example.carniceria_tfg.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Elaboracion {
    @SerializedName("elaboracion_id")
    @Expose
    private int elaboracion_id;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("semanaElaboracion")
    @Expose
    private String semanaElaboracion;
    @SerializedName("cantidadElaborada")
    @Expose
    private int cantidadElaborada;
    @SerializedName("carne")
    @Expose
    private Carne carne;
    @SerializedName("ingredientes")
    @Expose
    private String ingredientes;


    public Elaboracion(int elaboracion_id, String codigo, String nombre, String semanaElaboracion, int cantidadElaborada, Carne carne, String ingredientes) {
        this.elaboracion_id = elaboracion_id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.semanaElaboracion = semanaElaboracion;
        this.cantidadElaborada = cantidadElaborada;
        this.carne = carne;
        this.ingredientes = ingredientes;
    }

    public Elaboracion(String nombre, int cantidadElaborada, Carne carne, String ingredientes) {
        this.nombre = nombre;
        this.cantidadElaborada = cantidadElaborada;
        this.carne = carne;
        this.ingredientes = ingredientes;

        // Generar el código de elaboración utilizando el número de semana actual
        LocalDate fechaActual = LocalDate.now();
        int numeroSemana = fechaActual.get(WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear());
        this.semanaElaboracion = "S" + numeroSemana;

        // Generar el código de producto utilizando el número de semanas de elaboración y el nombre del producto
        this.codigo = this.semanaElaboracion + "-" + this.nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemanaElaboracion() {
        return semanaElaboracion;
    }

    public void setSemanaElaboracion(String semanaElaboracion) {
        this.semanaElaboracion = semanaElaboracion;
    }

    public int getCantidadElaborada() {
        return cantidadElaborada;
    }

    public void setCantidadElaborada(int cantidadElaborada) {
        this.cantidadElaborada = cantidadElaborada;
    }

    public Carne getCarne() {
        return carne;
    }

    public void setCarne(Carne carne) {
        this.carne = carne;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getElaboracion_id() {
        return elaboracion_id;
    }

    public void setElaboracion_id(int elaboracion_id) {
        this.elaboracion_id = elaboracion_id;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String toStringFull() {
        return "Elaboracion{" + "codigo='" + codigo + '\'' + ", nombre='" + nombre + '\'' + ", semanaElaboracion='" + semanaElaboracion + '\'' + ", cantidadElaborada=" + cantidadElaborada + ", carne=" + carne + ", ingredientes='" + ingredientes + '\'' + '}';
    }

}
