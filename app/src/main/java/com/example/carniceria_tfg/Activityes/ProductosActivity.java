package com.example.carniceria_tfg.Activityes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.Adaptadores.Productos.MyAdapter;
import com.example.carniceria_tfg.Adaptadores.Productos.OnItemClickListener;
import com.example.carniceria_tfg.Formularios.Formulario_Productos;
import com.example.carniceria_tfg.Model.Productos;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.Api;
import com.example.carniceria_tfg.Utils.ApiService;
import com.example.carniceria_tfg.Utils.Delete_Dialog_Productos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosActivity extends AppCompatActivity implements OnItemClickListener {
    ApiService carneService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        carneService = Api.getApiService();
        RecyclerView recyclerView = findViewById(R.id.recyclerview_productos);
        Context context = this;
        OnItemClickListener onItemClickListener = this;
        Call<List<Productos>> call = carneService.getProductos();
        call.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                List<Productos> productos = new ArrayList<>();
                productos.add(new Productos(1, "Producto_1", "Descripcion", 11, 12, true));
                List<Productos> body = response.body();
                assert body != null;
                body.forEach(producto -> {
                    Productos newProducto = new Productos(producto.getProductos_id(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getCantidad(), producto.isDisponibilidad(), producto.getElaboracion(), producto.getCarne());
                    productos.add(newProducto);
                });
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                MyAdapter myAdapter = new MyAdapter(context, productos, onItemClickListener);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<Productos>> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(this, "borrar", Toast.LENGTH_SHORT).show();

                openDialog();
                break;
            case R.id.update:
                Toast.makeText(this, "Actualizar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Formulario_Productos.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.refresh:
                Intent intento = new Intent(this, ProductosActivity.class);
                intento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intento);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog() {
        Delete_Dialog_Productos deleteDialog = new Delete_Dialog_Productos();

        deleteDialog.show(getSupportFragmentManager(), "Delete Dialog");

    }

    @Override
    public void onItemClick(Productos item) {
        Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(Productos item) {
        Toast.makeText(this, "Toast Largo", Toast.LENGTH_SHORT).show();
    }
}