package com.example.recuperacionud1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MapasApiCliente {
    public ArrayList<Mapa>getMaps() {
        String url = "https://valorant-api.com/v1/maps";

        String lista = null;
        try {
            String result = HttpUtils.get(url);
            JSONObject jsonResult = new JSONObject(result);
            JSONArray results = jsonResult.getJSONArray("data");

            ArrayList<Mapa> listaMapas = new ArrayList<Mapa>();

            for (int i = 0; i < 9; i++) {
                try {

                    JSONObject mapaJson = results.getJSONObject(i);

                    Mapa Mapas = new Mapa();
                    Mapas.setName(mapaJson.getString("displayName"));
                    Mapas.setCoordinates(mapaJson.getString("coordinates"));
                    Mapas.setUuid(mapaJson.getString("uuid"));
                    Mapas.setLv_mapIcon(mapaJson.getString("listViewIcon"));
                    Mapas.setMapImage(mapaJson.getString("displayIcon"));
                    Mapas.setMaxmapimage(mapaJson.getString("splash"));

                    lista = String.valueOf(Mapas);
                    Log.i("RESULTADOS: " ,lista);

                    listaMapas.add(Mapas);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return listaMapas;

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;

    }



}
