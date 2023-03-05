package com.example.recuperacionud1.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.recuperacionud1.Detalles;
import com.example.recuperacionud1.Mapa;
import com.example.recuperacionud1.MapasAdapter;
import com.example.recuperacionud1.MapasApiCliente;
import com.example.recuperacionud1.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private ArrayList<Mapa> items;
    private MapasAdapter adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.first_mapaslv, container, false);


       items = new ArrayList<>();

       adapter = new MapasAdapter(
                getContext(),
                R.layout.fragment_first,
                R.id.txtMapaRow,
                items
        );


        ListView lvMapas = view.findViewById(R.id.lvMapas);
        lvMapas.setAdapter(adapter);

        lvMapas.setOnItemClickListener((parent, view1, position, id) -> {
            Mapa mapa = adapter.getItem(position);

            Intent i = new Intent(getContext(), Detalles.class);
            i.putExtra("mapa", mapa);

            startActivity(i);
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            MapasApiCliente api = new MapasApiCliente();
            ArrayList<Mapa> mapas = api.getMaps();
            handler.post(() -> {
                adapter.clear();
                for (Mapa mapa : mapas) {
                    adapter.add(mapa);
                }
            });
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.refresh) {
            refresh();
        }

        return super.onOptionsItemSelected(item);
    }
}