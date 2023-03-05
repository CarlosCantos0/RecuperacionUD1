package com.example.recuperacionud1;

import java.io.Serializable;

public class Mapa implements Serializable {

    private String name;
    private String coordinates;
    private String lv_mapIcon;
    private String mapImage;
    private String uuid;
    private String maxmapimage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getLv_mapIcon() {
        return lv_mapIcon;
    }

    public void setLv_mapIcon(String lv_mapIcon) {
        this.lv_mapIcon = lv_mapIcon;
    }

    public String getMapImage() {
        return mapImage;
    }

    public void setMapImage(String mapImage) {
        this.mapImage = mapImage;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMaxmapimage() {
        return maxmapimage;
    }

    public void setMaxmapimage(String maxmapimage) {
        this.maxmapimage = maxmapimage;
    }

    @Override
    public String toString() {
        return "ValorantMaps{" +
                "name='" + name + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", lv_mapIcon='" + lv_mapIcon + '\'' +
                ", mapImage='" + mapImage + '\'' +
                ", detailsUuid='" + uuid + '\'' +
                ", MaxMapimage='" + maxmapimage + '\'' +
                '}';
    }
}
