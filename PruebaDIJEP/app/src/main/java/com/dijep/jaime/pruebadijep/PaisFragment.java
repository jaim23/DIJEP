package com.dijep.jaime.pruebadijep;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Jaime on 10/12/2015.
 */

public class PaisFragment extends Fragment {

    public final static int ADD_REQUEST_CODE = 1;
    private PaisAdapter adapter;
    private RecyclerView recycler;
    private List<Pais> items;

    public PaisFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaisesDataSource dataSource = new PaisesDataSource(getContext());
        items = dataSource.getAll();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.pais_fragment, container, false);
        recycler = (RecyclerView) rootView.findViewById(R.id.reciclador_pais);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        adapter = new PaisAdapter(items);
        recycler.setAdapter(adapter);
        return rootView;

    }


}

