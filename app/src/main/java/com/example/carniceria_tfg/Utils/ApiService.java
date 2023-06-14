package com.example.carniceria_tfg.Utils;

import com.example.carniceria_tfg.Model.Carne;
import com.example.carniceria_tfg.Model.Elaboracion;
import com.example.carniceria_tfg.Model.Productos;
import com.example.carniceria_tfg.Model.Proveedor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @GET("carne")
    Call<List<Carne>> getCarnes();

    @GET("elaboraciones")
    Call<List<Elaboracion>> getElaboraciones();

    @GET("productos")
    Call<List<Productos>> getProductos();

    @GET("proveedores")
    Call<List<Proveedor>> getProveedores();

    @PUT("/carne/deleteCarne/{nombre}")
    Call<Void> deleteCarne(@Path("nombre") String nombre);

    @POST("/carne/addCarne")
    Call<Carne> createCarne(@Body Carne carne);

    @POST("/elaboraciones/addElaboracion")
    Call<Elaboracion> addElaboracion(@Body Elaboracion elaboracion);

    @DELETE("/elaboraciones/deleteElaboracion/{id}")
    Call<Void> deleteElaboracion(@Path("id") int id);

    @POST("/productos/addProduct")
    Call<Productos> addProductos(@Body Productos producto);

    @POST("/proveedores/addProveedor")
    Call<Proveedor> addProveedor(@Body Proveedor proveedor);

    @DELETE("/proveedores/deleteProveedor/{id}")
    Call<Void> deleteProveedor(@Path("id") int id);

}
