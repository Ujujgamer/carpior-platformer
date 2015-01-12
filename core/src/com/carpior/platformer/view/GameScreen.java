package com.carpior.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.carpior.platformer.controller.CameraController;
import com.carpior.platformer.controller.LevelController;
import com.carpior.platformer.controller.PlayerController;
import com.carpior.platformer.model.Player;

public class GameScreen implements Screen{

    public GameScreen() {
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.initializeController();
    }

    @Override
    public void render(float delta) {
        //set the color of the clear
        Gdx.gl.glClearColor(0.36f, 0.97f, 1f, 1f);
        //clears the game screen and the color buffer
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        CameraController.update();
        LevelController.update();
        PlayerController.update(delta);
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
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
