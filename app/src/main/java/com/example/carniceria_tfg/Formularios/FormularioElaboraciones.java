package com.example.carniceria_tfg.Formularios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carniceria_tfg.Activityes.CarneActivity;
import com.example.carniceria_tfg.Model.Carne;
import com.example.carniceria_tfg.Model.Elaboracion;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.Api;
import com.example.carniceria_tfg.Utils.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormularioElaboraciones extends AppCompatActivity {
    ApiService carneService;
    private EditText nombre_Elaboraciones, cantidadElaboracion, ingredientes_Elaboracion;
    private Spinner spinnerCarne;
    private Button addElaboracion, updateElaboracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_elaboraciones);
        nombre_Elaboraciones = findViewById(R.id.editTextNombre_Elaboracion);
        cantidadElaboracion = findViewById(R.id.editTextCantidadElaborada);
        ingredientes_Elaboracion = findViewById(R.id.editTextTextMultiLineIngredientes);
        spinnerCarne = findViewById(R.id.spinnerCarne);
        addElaboracion = findViewById(R.id.addElaboracion);
        updateElaboracion = findViewById(R.id.updateElaboracion);
        List<Carne> listaCarne = llenarListaCarne();
        listaCarne.add(new Carne("Pollo", null, 5, "2023-05-12"));
        setSpinnerAdapter(listaCarne);
        addElaboracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElaboracion();
                Toast.makeText(FormularioElaboraciones.this, "insercion ralizada con existo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormularioElaboraciones.this, CarneActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });
        updateElaboracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addElaboracion();
                Toast.makeText(FormularioElaboraciones.this, "Actualizacion ralizada con existo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormularioElaboraciones.this, CarneActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });

    }

    private void addElaboracion() {
        Elaboracion elaboracion = new Elaboracion(nombre_Elaboraciones.getText().toString(), Integer.parseInt(cantidadElaboracion.getText().toString()), (Carne) spinnerCarne.getSelectedItem(), ingredientes_Elaboracion.getText().toString());
        Call<Elaboracion> call = carneService.addElaboracion(elaboracion);
        call.enqueue(new Callback<Elaboracion>() {
            @Override
            public void onResponse(Call<Elaboracion> call, Response<Elaboracion> response) {

            }

            @Override
            public void onFailure(Call<Elaboracion> call, Throwable t) {
                Toast.makeText(FormularioElaboraciones.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setSpinnerAdapter(List<Carne> listaCarne) {
        ArrayAdapter<Carne> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaCarne);
        spinnerCarne.setAdapter(adapter);
        spinnerCarne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mostrarNombreSeleccionado();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public List<Carne> llenarListaCarne() {
        carneService = Api.getApiService();
        List<Carne> carnes = new ArrayList<>();
        Call<List<Carne>> carnesAPI = carneService.getCarnes();
        carnesAPI.enqueue(new Callback<List<Carne>>() {
            @Override
            public void onResponse(Call<List<Carne>> call, Response<List<Carne>> response) {
                List<Carne> body = response.body();
                assert body != null;
                carnes.addAll(body);
            }

            @Override
            public void onFailure(Call<List<Carne>> call, Throwable t) {

            }
        });


        return carnes;
    }

    private void mostrarNombreSeleccionado() {
        Carne carne = (Carne) spinnerCarne.getSelectedItem();
        Toast.makeText(this, carne.getNombre(), Toast.LENGTH_SHORT).show();
    }
}