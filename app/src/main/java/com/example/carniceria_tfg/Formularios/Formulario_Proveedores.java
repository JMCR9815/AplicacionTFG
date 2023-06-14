package com.example.carniceria_tfg.Formularios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carniceria_tfg.Activityes.ProveedoresActivity;
import com.example.carniceria_tfg.Model.Proveedor;
import com.example.carniceria_tfg.R;
import com.example.carniceria_tfg.Utils.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Formulario_Proveedores extends AppCompatActivity {
    ApiService carniceriaService;
    private EditText nombreProveedor, telefonoProveedor;
    private Button addProveedor, updateProveedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_proveedores);
        nombreProveedor = findViewById(R.id.editTextNombreProveedor);
        telefonoProveedor = findViewById(R.id.editTextTelefono);
        addProveedor = findViewById(R.id.buttonAddProveedor);
        updateProveedor = findViewById(R.id.buttonUpdateProveedor);
        addProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proveedor proveedor = new Proveedor(nombreProveedor.getText().toString(), telefonoProveedor.getText().toString());
                addProveedor(proveedor);
                Toast.makeText(Formulario_Proveedores.this, "Proveedor Aàdido", Toast.LENGTH_SHORT).show();
                Intent intento = new Intent(Formulario_Proveedores.this, ProveedoresActivity.class);
                startActivity(intento);
            }
        });

    }

    private void addProveedor(Proveedor proeedor) {
        Call<Proveedor> proveedorCall = carniceriaService.addProveedor(proeedor);
        proveedorCall.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {

            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                Toast.makeText(Formulario_Proveedores.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}