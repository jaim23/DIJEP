package com.dijep.jaime.pruebadijep;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jaime on 10/12/2015.
 */
public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.PaisViewHolder> {
    private List<Pais> items;

    public PaisAdapter(FragmentManager fm){ super(); }

    public Fragment getItem(int position)
    {
        switch (position){
            case 0 : return new PaisFragment();
            case 1 : return new InfoFragment();
        }

        return null;
    }

    public static class PaisViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;


        public PaisViewHolder(View v) {
            super(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Al seleccionar elemento de la Lista
                }
            });

            imagen = (ImageView) v.findViewById(R.id.imagen_pais);
            nombre = (TextView) v.findViewById(R.id.nombre_pais);
        }
    }

    public PaisAdapter(List<Pais> items) {
        super();
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public PaisViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pais_card, viewGroup, false);
        return new PaisViewHolder(v);
    }
    //private Context context;
    @Override
    public void onBindViewHolder(PaisViewHolder viewHolder, int i) {
      /* int resID = context.getResources().getIdentifier(items.get(i).getImagen(), "drawable","com.dijep.jaime");
        viewHolder.imagen.setImageResource(resID);*/
        viewHolder.nombre.setText(items.get(i).getNombre());
    }
}