package com.example.recuperacionud1.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recuperacionud1.Mapa;
import com.example.recuperacionud1.R;

public class DetallesFragment extends Fragment {

    private DetallesViewModel mViewModel;
    private TextView coordDetail;
    private TextView uuidDetail;
    private ImageView imageDetail;

    public static DetallesFragment newInstance() {
        return new DetallesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetallesViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main2, container, false);

        uuidDetail = view.findViewById(R.id.txtUuidDetalle);
        coordDetail = view.findViewById(R.id.txtCoordenadasDetalle);
        imageDetail = view.findViewById(R.id.imgMapaDetalle);

        Intent intent = getActivity().getIntent();

        if(intent != null) {
            Mapa mapa = (Mapa) intent.getSerializableExtra("mapa");

            if (mapa != null) {
                showData(mapa);
            }
        }


        return view;
    }

    private void showData(Mapa mapa) {
        coordDetail.setText(mapa.getCoordinates());
        uuidDetail.setText(mapa.getUuid());
        Glide.with(getContext()).load("" + mapa.getMapImage()).into(imageDetail);

    }

}