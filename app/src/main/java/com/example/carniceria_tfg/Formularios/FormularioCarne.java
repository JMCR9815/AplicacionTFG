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
import com.example.carniceria_tfg.Model.Proveedor;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.Api;
import com.example.carniceria_tfg.Utils.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormularioCarne extends AppCompatActivity {
    ApiService carneService;
    private EditText editTextCantidad, editTextNombre, editTextFecha;
    private Spinner spinnerProveedores;
    private Button addCarne, actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carne);
        editTextCantidad = findViewById(R.id.editTextCantidad);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextFecha = findViewById(R.id.editTextFecha);
        spinnerProveedores = findViewById(R.id.spinnerProveedores);
        addCarne = findViewById(R.id.addCarne);
        actualizar = findViewById(R.id.actualizarCarne);
        List<Proveedor> proveedores = llenarListaProveedores();
        proveedores.add(new Proveedor(0, "Juan", "123456"));
        setSpinnerAdapter(proveedores);
        addCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCarne();
                Toast.makeText(FormularioCarne.this, "insercion ralizada con existo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormularioCarne.this, CarneActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCarne();
                Toast.makeText(FormularioCarne.this, "Actualizacion ralizada con existo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormularioCarne.this, CarneActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }

    private void addCarne() {
        Carne carne = new Carne(editTextNombre.getText().toString(), (Proveedor) spinnerProveedores.getSelectedItem(), Integer.parseInt(editTextCantidad.getText().toString()), editTextFecha.getText().toString());
        //Toast.makeText(FormularioCarne.this, carne.toString(), Toast.LENGTH_SHORT).show();
        Call<Carne> call = carneService.createCarne(carne);
        call.enqueue(new Callback<Carne>() {
            @Override
            public void onResponse(Call<Carne> call, Response<Carne> response) {
                if (!response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<Carne> call, Throwable t) {
                Toast.makeText(FormularioCarne.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setSpinnerAdapter(List<Proveedor> proveedores) {
        ArrayAdapter<Proveedor> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, proveedores);
        spinnerProveedores.setAdapter(adapter);
        spinnerProveedores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mostrarNombreSeleccionado();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public List<Proveedor> llenarListaProveedores() {
        carneService = Api.getApiService();
        List<Proveedor> proveedors = new ArrayList<>();
        Call<List<Proveedor>> proveedoresAPI = carneService.getProveedores();
        proveedoresAPI.enqueue(new Callback<List<Proveedor>>() {
            @Override
            public void onResponse(Call<List<Proveedor>> call, Response<List<Proveedor>> response) {
                List<Proveedor> body = response.body();
                assert body != null;
                proveedors.addAll(body);
            }

            @Override
            public void onFailure(Call<List<Proveedor>> call, Throwable t) {

            }
        });

        return proveedors;
    }

    private void mostrarNombreSeleccionado() {
        Proveedor proveedor = (Proveedor) spinnerProveedores.getSelectedItem();
        Toast.makeText(this, proveedor.getNombre(), Toast.LENGTH_SHORT).show();
    }
}