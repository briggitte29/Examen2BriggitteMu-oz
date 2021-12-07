package com.example.examen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class tercerFragmento extends Fragment {

    private BottomSheetBehavior<View> bottomSheetBehavior;
    private Slide slide;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomSheetBehavior.from(view.findViewById(R.id.sheetbtn)).setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    public int gesState(){
        return bottomSheetBehavior.getState();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tercer_fragmento,container,false);
        setUpToolbar(view);
        return view;
    }

    private void setUpToolbar(View view){
        Toolbar toolbar=view.findViewById(R.id.app_bar2);
        AppCompatActivity activity=(AppCompatActivity) getActivity();
        if(activity!=null){
            activity.setSupportActionBar(toolbar);
        }
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_tres,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}