package com.carpior.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.carpior.platformer.model.Enemy;
import com.carpior.platformer.model.Player;

public class EnemyController {
    public static Enemy enemy;

    public static void initializeController() {
        enemy = new Enemy(new Vector2(4, 5), 51, 58, "img/enemy-barnacle.png");
    }

    public static void update(float deltaTime) {
        enemy.update(deltaTime);
    }
}
