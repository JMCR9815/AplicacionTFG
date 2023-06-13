package com.example.carniceria_tfg.Activityes;

import android.annotation.SuppressLint;
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

import com.example.carniceria_tfg.Adaptadores.Carne.MyAdapter;
import com.example.carniceria_tfg.Adaptadores.Carne.OnItemClickListener;
import com.example.carniceria_tfg.Formularios.FormularioCarne;
import com.example.carniceria_tfg.Model.Carne;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.Api;
import com.example.carniceria_tfg.Utils.ApiService;
import com.example.carniceria_tfg.Utils.Delete_Dialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarneActivity extends AppCompatActivity implements OnItemClickListener {

    ApiService carneService;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carne);
        carneService = Api.getApiService();
        RecyclerView recyclerView = findViewById(R.id.reciclerview_carne);
        Context context = this;
        OnItemClickListener onItemClickListener = this;
        Call<List<Carne>> call = carneService.getCarnes();


        call.enqueue(new Callback<List<Carne>>() {
            @Override
            public void onResponse(Call<List<Carne>> call, Response<List<Carne>> response) {
                List<Carne> carnes = new ArrayList<>();
                carnes.add(new Carne(0, "0", null, 20, "12-21-22"));

                List<Carne> body = response.body();
                //res += carne.getCarne_id() + " " + carne.getNombre() + " " + carne.getProveedor() + " " + carne.getCantidad() + " " + carne.getFecha_entrada() + "\n";
                assert body != null;
                body.forEach(carne -> {
                    Carne newCarne = new Carne(carne.getCarne_id(), carne.getNombre(), carne.getProveedor(), carne.getCantidad(), carne.getFecha_entrada());
                    carnes.add(carne);
                });
                Log.d("outRes", String.valueOf(carnes.get(0).getNombre()));
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                MyAdapter myAdapter = new MyAdapter(context, carnes, onItemClickListener);
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<List<Carne>> call, Throwable t) {
                Log.e("Error", Objects.requireNonNull(t.getMessage()));
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
                Intent intent = new Intent(this, FormularioCarne.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.refresh:
                Intent intento = new Intent(this, CarneActivity.class);
                intento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intento);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(Carne item) {
        Toast.makeText(this, item.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(Carne item) {

        Toast.makeText(this, "Toast largo", Toast.LENGTH_SHORT).show();
    }

    public void openDialog() {
        Delete_Dialog deleteDialog = new Delete_Dialog();

        deleteDialog.show(getSupportFragmentManager(), "Delete Dialog");

    }
}