package com.carpior.platformer.controller;

import com.carpior.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static void initializeController() {
        player = new Player(70,100);
    }

    public static void update(float deltaTime) {
        player.update(deltaTime);
    }
}
