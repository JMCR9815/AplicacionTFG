package com.example.carniceria_tfg.Utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.carniceria_tfg.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delete_Dialog_elaboraciones extends AppCompatDialogFragment {
    ApiService carneService;
    Context context;
    private EditText editTextDelete;
    private DeleteDialogListener deleteDialogListener;
    private String nombreElaboracion;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        context = this.getContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout_elaboraciones, null);
        editTextDelete = view.findViewById(R.id.editTextArtProducto);
        builder.setView(view).setTitle("Borrar").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Aceppt", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                carneService = Api.getApiService();
                deleteArticulo(editTextDelete.getText().toString());


            }

            private void deleteArticulo(String string) {
                Call<Void> delete = carneService.deleteElaboracion(Integer.parseInt(editTextDelete.getText().toString()));
                delete.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (call.isExecuted()) {

                            Toast.makeText(context, "Elemento borrado con exito", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });
            }
        });

        return builder.create();
    }

    public String getELement() {
        return nombreElaboracion;
    }


    public interface DeleteDialogListener {
        String getElement(String elemet);
    }

}
