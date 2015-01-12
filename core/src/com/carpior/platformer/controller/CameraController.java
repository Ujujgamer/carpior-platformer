package com.carpior.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController() {
        //gets width/height of the window and stores them as variables
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        //set the length and width of the map 14x14
        camera = new OrthographicCamera(14f, 14f * (height/width));
        //sets the camera's position
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public static void update() {
        //updates the camera's position
        camera.update();
    }

    public static void resize(int width, int height) {
        //set the viewport width
        camera.viewportWidth = 14f;
        //set the viewport height
        camera.viewportHeight = 14f * height / width;
        camera.update();

    }
}
