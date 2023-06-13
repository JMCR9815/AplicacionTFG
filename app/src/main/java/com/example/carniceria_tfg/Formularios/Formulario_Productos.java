package com.example.carniceria_tfg.Formularios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carniceria_tfg.Activityes.ProductosActivity;
import com.example.carniceria_tfg.Model.Elaboracion;
import com.example.carniceria_tfg.Model.Productos;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.Api;
import com.example.carniceria_tfg.Utils.ApiService;
import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Formulario_Productos extends AppCompatActivity {
    ApiService carneService;
    private EditText nombre_producto, descripcionProducto, cantidad_producto, precio_producto;
    private Chip chipDisponibilidad;
    private Spinner elaboraciones;
    private Button addProducto, updateProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_productos);
        nombre_producto = findViewById(R.id.editTextNombreProducto);
        descripcionProducto = findViewById(R.id.editTextDescripcionProducto);
        cantidad_producto = findViewById(R.id.editTextCantidadProducto);
        precio_producto = findViewById(R.id.editTextPrecioProducto);
        elaboraciones = findViewById(R.id.spinnerElaboraciones);
        addProducto = findViewById(R.id.buttonAddProducto);
        updateProducto = findViewById(R.id.buttonUpdateProduct);
        List<Elaboracion> listaElaboracion = llenarListaElaboracion();
        listaElaboracion.add(new Elaboracion("0", 0, null, "0"));
        setSpinnerAdapter(listaElaboracion);
        addProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductos();
                Toast.makeText(Formulario_Productos.this, "Actualizacion ralizada con existo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Formulario_Productos.this, ProductosActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });
        updateProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductos();
                Toast.makeText(Formulario_Productos.this, "Actualizacion ralizada con existo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Formulario_Productos.this, ProductosActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });
    }

    private void addProductos() {
        Productos producto = new Productos(nombre_producto.getText().toString(), descripcionProducto.getText().toString(), Integer.parseInt(precio_producto.getText().toString()), Integer.parseInt(cantidad_producto.getText().toString()), true, (Elaboracion) elaboraciones.getSelectedItem(), null);
        Call<Productos> call = carneService.addProductos(producto);
        call.enqueue(new Callback<Productos>() {
            @Override
            public void onResponse(Call<Productos> call, Response<Productos> response) {

            }

            @Override
            public void onFailure(Call<Productos> call, Throwable t) {
                Toast.makeText(Formulario_Productos.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private List<Elaboracion> llenarListaElaboracion() {
        carneService = Api.getApiService();
        List<Elaboracion> elaboraciones = new ArrayList<>();
        Call<List<Elaboracion>> call = carneService.getElaboraciones();
        call.enqueue(new Callback<List<Elaboracion>>() {
            @Override
            public void onResponse(Call<List<Elaboracion>> call, Response<List<Elaboracion>> response) {
                List<Elaboracion> body = response.body();
                assert body != null;
                elaboraciones.addAll(body);
            }

            @Override
            public void onFailure(Call<List<Elaboracion>> call, Throwable t) {

            }
        });
        return elaboraciones;
    }

    private void setSpinnerAdapter(List<Elaboracion> listaElaboracion) {
        ArrayAdapter<Elaboracion> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaElaboracion);
        elaboraciones.setAdapter(adapter);
    }
}