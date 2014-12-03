package com.carpior.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.carpior.platformer.model.Player;

public class GameScreen implements Screen{
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public SpriteBatch spriteBatch;
    public Player player;

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

        spriteBatch = new SpriteBatch();
        player = new Player();
    }

    @Override
    public void render(float delta) {
        //set the color of the clear
        Gdx.gl.glClearColor(0.36f, 0.97f, 1f, 1f);
        //clears the game screen and the color buffer
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //updates the camera's position
        camera.update();
        //renders the map for the camera
        renderer.setView(camera);
        //renders the render
        renderer.render();

        //calls SpriteBatch to begin drawing on screen
        spriteBatch.begin();
        //uses SpriteBatch object to draw player
        player.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        //set the viewport width
        camera.viewportWidth = 14f;
        //set the viewport height
        camera.viewportHeight = 14f * height / width;
        camera.update();

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
