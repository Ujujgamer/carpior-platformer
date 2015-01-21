package com.carpior.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public static TiledMap map;

    public Level(String mapPath) {
        //loads the map from the assets folder
        map = new TmxMapLoader().load(mapPath);
    }

    public MapLayer getMapLayer(String layerName) {
        return map.getLayers().get(layerName);
    }

    public MapObjects getMapObjects(MapLayer mapLayer) {
        return mapLayer.getObjects();
    }
}