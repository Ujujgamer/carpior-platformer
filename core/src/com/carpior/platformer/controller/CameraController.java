package com.carpior.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static float widthScale;
    public static float heightScale;

    public static void initializeController() {
        //gets width/height of the window and stores them as variables
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        //set the length and width of the map 14x14
        camera = new OrthographicCamera(14f, 14f * (height/width));
        //sets the camera's position
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);

        inputCamera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();
    }

    public static void update() {
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0);
        //updates the camera's position
        camera.update();
    }

    public static void resize(int width, int height) {
        //set the viewport width
        camera.viewportWidth = 14f;
        //set the viewport height
        camera.viewportHeight = 14f * height / width;
        camera.update();

        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height / width;
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();

        widthScale = width / inputCamera.viewportWidth * LevelController.UNIT_SCALE;
        heightScale = height / inputCamera.viewportWidth * LevelController.UNIT_SCALE;

    }
}
