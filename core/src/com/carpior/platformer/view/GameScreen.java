package com.carpior.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen{
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        //loads the map from the assets folder
        map = new TmxMapLoader().load("map/level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);

        //gets width/height of the window and stores them as variables
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        //set the length and width of the map 14x14
        camera = new OrthographicCamera(14f, 14f * (height/width));
        //sets the camera's position
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    @Override
    public void render(float delta) {
        //updates the camera's position
        camera.update();
        //renders the map for the camera
        renderer.setView(camera);
        //renders the render
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
