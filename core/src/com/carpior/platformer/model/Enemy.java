package com.carpior.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.carpior.platformer.controller.LevelController;

public class Enemy extends Sprite {
    public Enemy(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        animations.put("attack", spriteSheet.createAnimation(0, 1, 0.1f));
        animations.put("dead", spriteSheet.createAnimation(2, 3, 0.1f));

        currentAnimation = "dead";
    }

    public void draw(Batch spriteBatch) {
        super.draw(spriteBatch);
    }

    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
