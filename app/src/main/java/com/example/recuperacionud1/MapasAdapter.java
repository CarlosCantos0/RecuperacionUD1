package com.example.recuperacionud1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class MapasAdapter extends ArrayAdapter<Mapa> {

    public MapasAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Mapa> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Mapa mapa = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_mps_row, parent, false);
        }

        TextView name = convertView.findViewById(R.id.txtMapaRow);
        //TextView uuid = convertView.findViewById(R.id.txtUuid);
        ImageView imageMap = convertView.findViewById(R.id.imgMap);

        name.setText(mapa.getName());
        //uuid.setText(mapa.getUuid());
        Glide.with(getContext()).load("" + mapa.getLv_mapIcon()).into(imageMap);

        return convertView;
    }
}
