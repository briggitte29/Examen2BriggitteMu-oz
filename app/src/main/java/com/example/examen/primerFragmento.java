package com.example.examen;

import android.content.ClipData;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Network.Producto;

import java.lang.reflect.Array;

public class primerFragmento extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Habilitar el toolbar
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.primer_fragment_layout,container,false);
        setUpToolbar(view);
        RecyclerView recyclerView=view.findViewById(R.id.rev);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false));
        ProductoCardRecyclerViewAdapter adapter=new ProductoCardRecyclerViewAdapter(
                Producto.initProductoList(getResources()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void setUpToolbar(View view){
        Toolbar toolbar=view.findViewById(R.id.app_bar);
        AppCompatActivity activity=(AppCompatActivity) getActivity();
        if(activity!=null){
            activity.setSupportActionBar(toolbar);
        }
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
