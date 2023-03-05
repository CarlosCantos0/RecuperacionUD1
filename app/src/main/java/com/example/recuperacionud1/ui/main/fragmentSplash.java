package com.example.recuperacionud1.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.recuperacionud1.Mapa;
import com.example.recuperacionud1.R;

public class fragmentSplash extends Fragment {

    private ImageView imageMap;

    public fragmentSplash(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        imageMap = view.findViewById(R.id.imgSplash);

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
        Glide.with(getContext()).load("" + mapa.getMaxmapimage()).into(imageMap);
    }
}
