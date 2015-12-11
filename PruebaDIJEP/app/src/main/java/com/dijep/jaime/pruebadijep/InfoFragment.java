package com.dijep.jaime.pruebadijep;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Jaime on 11/12/2015.
 */
public class InfoFragment extends Fragment{
        private InfoAdapter adapter;
        private RecyclerView recycler;
       private List<Info> items;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            PaisesDataSource dataSource = new PaisesDataSource(getContext());
            items = dataSource.getInfo("España");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.info_fragment, container, false);
            recycler = (RecyclerView) rootView.findViewById(R.id.reciclador_info);
            recycler.setHasFixedSize(false);
            // Usar un administrador para LinearLayout
            LinearLayoutManager lManager = new LinearLayoutManager(getActivity());
            recycler.setLayoutManager(lManager);

            // Crear un nuevo adaptador
            adapter = new InfoAdapter(this.getContext());
            recycler.setAdapter(adapter);

            return rootView;
        }


    }

