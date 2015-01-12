package com.carpior.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.carpior.platformer.model.Level;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    //creates a static world
    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController() {
        level = new Level("map/level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(Level.map, UNIT_SCALE);
        //creates a "gravity"
        gameWorld = new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();
        spriteBatch = renderer.getSpriteBatch();
    }

    public static void draw() {
        //calls SpriteBatch to begin drawing on screen
        spriteBatch.begin();
        //uses SpriteBatch object to draw player
        PlayerController.player.draw(spriteBatch);
        spriteBatch.end();

        //renders the gameWorld and
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update() {
        //renders the map for the camera
        renderer.setView(CameraController.camera);
        //renders the render
        renderer.render();
        gameWorld.step(1/60f, 1, 1);
    }
}
