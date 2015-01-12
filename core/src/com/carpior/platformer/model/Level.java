package com.carpior.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public static TiledMap map;

    public Level(String mapPath) {
        //loads the map from the assets folder
        map = new TmxMapLoader().load(mapPath);
    }
}
