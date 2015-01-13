package com.carpior.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.carpior.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static void initializeController() {
        player = new Player(new Vector2(2, 5), 70,100);
    }

    public static void update(float deltaTime) {
        player.update(deltaTime);
    }
}
