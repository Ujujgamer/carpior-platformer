package com.carpior.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.carpior.platformer.model.Bodies;
import com.carpior.platformer.model.Level;
import com.carpior.platformer.model.Sprite;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;
    public static final float ENEMY_UNIT_SCALE = 1/51f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    //creates a static world
    public static World gameWorld;
    private static Array<Body> worldBodies;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController() {
        level = new Level("map/level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(Level.map, UNIT_SCALE);
        //creates a "gravity"
        gameWorld = new World(new Vector2(0, -10), true);
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();
        spriteBatch = renderer.getSpriteBatch();
        createLevelBodies();
    }

    public static void draw() {
        //calls SpriteBatch to begin drawing on screen
        spriteBatch.begin();
        //uses SpriteBatch object to draw player
        PlayerController.player.draw(spriteBatch);
        EnemyController.enemy.draw(spriteBatch);
        spriteBatch.end();

        //renders the gameWorld and
        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }

    public static void update() {
        //renders the map for the camera
        renderer.setView(CameraController.camera);
        //renders the render
        renderer.render();
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1);
    }

    private static void updateWorldBodies() {
        worldBodies.clear();
        gameWorld.getBodies(worldBodies);

        for(Body body : worldBodies) {
            Sprite spriteBody = (Sprite)body.getUserData();

            if(spriteBody != null) {
                spriteBody.position = body.getPosition();
            }
        }
    }

    private static void createLevelBodies() {
        MapObjects mapObjects = level.getMapObjects(level.getMapLayer("collision"));
        for(MapObject mapObject : mapObjects) {
            Bodies.createBody(mapObject);
        }
    }
}
