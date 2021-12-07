package com.example.examen;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;



public class ProductoCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView img;
    public TextView nombre;

    public ProductoCardViewHolder(@NonNull View itemView){
        super(itemView);

        img=itemView.findViewById(R.id.imgNetwork);
        nombre=itemView.findViewById(R.id.txtNombre);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), "Nombre: "+ nombre.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
