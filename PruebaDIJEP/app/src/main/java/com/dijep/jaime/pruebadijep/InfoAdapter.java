package com.dijep.jaime.pruebadijep;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Jaime on 11/12/2015.
 */
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    private List<Info> items;

    public static class InfoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
        public TextView habitantes;


        public InfoViewHolder(View v) {
            super(v);
            habitantes = (TextView) v.findViewById(R.id.info_hab);
            nombre = (TextView) v.findViewById(R.id.nombre_info);
        }
    }

    public InfoAdapter(Context c) {
        PaisesDataSource dataSource = new PaisesDataSource(c);
        items = dataSource.getInfo("España");
    }

    public int getItemCount() {
        return items.size();
    }

    public InfoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.info_card, viewGroup, false);
        return new InfoViewHolder(v);
    }

    public void onBindViewHolder(InfoViewHolder viewHolder, int i) {
        Info inf = items.get(i);
        viewHolder.nombre.setText(inf.getNombre());
        viewHolder.habitantes.setText(Integer.toString(inf.getHabitantes()));

    }
}
