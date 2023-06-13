package com.example.carniceria_tfg.Activityes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carniceria_tfg.Adaptadores.Elaboraciones.MyAdapter;
import com.example.carniceria_tfg.Adaptadores.Elaboraciones.OnItemClickListener;
import com.example.carniceria_tfg.Formularios.FormularioElaboraciones;
import com.example.carniceria_tfg.Model.Elaboracion;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.Api;
import com.example.carniceria_tfg.Utils.ApiService;
import com.example.carniceria_tfg.Utils.Delete_Dialog_elaboraciones;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElaboracionesActivity extends AppCompatActivity implements OnItemClickListener {
    ApiService carneService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elaboraciones);
        carneService = Api.getApiService();
        RecyclerView recyclerView = findViewById(R.id.recyclerview_elaboraciones);
        Context context = this;
        OnItemClickListener onItemClickListener = this;
        Call<List<Elaboracion>> call = carneService.getElaboraciones();


        call.enqueue(new Callback<List<Elaboracion>>() {
            @Override
            public void onResponse(@NonNull Call<List<Elaboracion>> call, Response<List<Elaboracion>> response) {
                List<Elaboracion> elaboraciones = new ArrayList<>();
                // elaboraciones.add(new Elaboracion(0, "codigo 1", "nombre 1", "s23", 0, null, "aaaaa"));

                List<Elaboracion> body = response.body();

                assert body != null;
                body.forEach(elaboracion -> {
                    Elaboracion elaboracion1 = new Elaboracion(elaboracion.getElaboracion_id(), elaboracion.getCodigo(), elaboracion.getNombre(), elaboracion.getSemanaElaboracion(), elaboracion.getCantidadElaborada(), elaboracion.getCarne(), elaboracion.getIngredientes());
                    elaboraciones.add(elaboracion1);
                });
                Log.d("outRes", elaboraciones.get(0).toString());
                Log.d("outRes", String.valueOf(elaboraciones.get(0).getCarne().getNombre()));
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                MyAdapter myAdapter = new MyAdapter(context, elaboraciones, onItemClickListener);
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<List<Elaboracion>> call, Throwable t) {

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
    public void onItemClick(Elaboracion item) {

    }

    @Override
    public void onLongItemClick(Elaboracion item) {

    }
}