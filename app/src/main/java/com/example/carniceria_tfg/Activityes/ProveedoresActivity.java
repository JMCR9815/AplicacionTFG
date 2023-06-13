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

import com.example.carniceria_tfg.Adaptadores.Proveedores.MyAdapter;
import com.example.carniceria_tfg.Adaptadores.Proveedores.OnItemClickListener;
import com.example.carniceria_tfg.Formularios.FormularioElaboraciones;
import com.example.carniceria_tfg.Model.Proveedor;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.Api;
import com.example.carniceria_tfg.Utils.ApiService;
import com.example.carniceria_tfg.Utils.Delete_Dialog_elaboraciones;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProveedoresActivity extends AppCompatActivity implements OnItemClickListener {
    ApiService carneService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_proveedores);
        // List<Proveedor> proveedores = new ArrayList<>();
        carneService = Api.getApiService();
        Context context = this;
        OnItemClickListener itemClickListener = this;
        //proveedores.add(new Proveedor(1, "nombre_proveedor", "00000000"));
        Call<List<Proveedor>> call = carneService.getProveedores();
        call.enqueue(new Callback<List<Proveedor>>() {
            @Override
            public void onResponse(Call<List<Proveedor>> call, Response<List<Proveedor>> response) {
                List<Proveedor> body = response.body();
                assert body != null;
                List<Proveedor> proveedores = new ArrayList<>(body);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                MyAdapter myAdapter = new MyAdapter(context, proveedores, itemClickListener);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<Proveedor>> call, Throwable t) {

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
                Intent intent = new Intent(this, FormularioElaboraciones.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.refresh:
                Intent intento = new Intent(this, ElaboracionesActivity.class);
                intento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intento);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog() {
        Delete_Dialog_elaboraciones deleteDialog = new Delete_Dialog_elaboraciones();

        deleteDialog.show(getSupportFragmentManager(), "Delete Elaboration Dialog");

    }

    @Override
    public void onItemClick(Proveedor item) {
        Toast.makeText(this, "HOla", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(Proveedor item) {
        Toast.makeText(this, "Toast largo", Toast.LENGTH_SHORT).show();
    }
}