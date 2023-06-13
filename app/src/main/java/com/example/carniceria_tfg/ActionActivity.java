package com.example.carniceria_tfg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carniceria_tfg.Activityes.CarneActivity;
import com.example.carniceria_tfg.Activityes.ElaboracionesActivity;
import com.example.carniceria_tfg.Activityes.ProductosActivity;
import com.example.carniceria_tfg.Activityes.ProveedoresActivity;

public class ActionActivity extends AppCompatActivity {
    ImageButton proveedores, carne, productos, elaboraciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        proveedores = findViewById(R.id.imageButton_proveedores);
        carne = findViewById(R.id.imageButton_carne);
        productos = findViewById(R.id.imageButton5);
        elaboraciones = findViewById(R.id.imageButton_elaboraciones);
        Context context = this.getBaseContext();
        proveedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProveedores = new Intent(context, ProveedoresActivity.class);
                startActivity(intentProveedores);
            }
        });
        carne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCarne = new Intent(context, CarneActivity.class);
                startActivity(intentCarne);
            }
        });
        productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProductos = new Intent(context, ProductosActivity.class);
                startActivity(intentProductos);
            }
        });
        elaboraciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentElaboraciones = new Intent(context, ElaboracionesActivity.class);
                startActivity(intentElaboraciones);
            }
        });

    }

}