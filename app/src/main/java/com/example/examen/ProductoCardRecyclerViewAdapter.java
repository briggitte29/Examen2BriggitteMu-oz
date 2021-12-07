package com.example.examen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Network.ImageRequester;
import com.example.examen.Network.Producto;

import java.util.List;

public class ProductoCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductoCardViewHolder> {

    public static List<Producto> productoList;
    public ImageRequester imageRequester;

    public ProductoCardRecyclerViewAdapter(List<Producto> productoList){
        this.productoList=productoList;
        imageRequester=ImageRequester.getInstance();
    }


    @NonNull
    @Override
    public ProductoCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lview= LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_item,parent,false);
        return new ProductoCardViewHolder(lview);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoCardViewHolder holder, int position) {
        if (productoList!=null && position< productoList.size()){
            Producto producto=productoList.get(position);
            //nombre
            holder.nombre.setText(producto.nombre);
            //imagen
            imageRequester.setImageFormUrl(holder.img, producto.imageUrl);


        }

    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }
}
