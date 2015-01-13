package com.carpior.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.carpior.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    //creates a variable for positions
    public Vector2 position;
    //creates a variable for spriteSheets
    public Spritesheet spriteSheet;
    public String currentAnimation;

    public float width;
    public float height;

    protected float stateTime;
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width, int height) {
        //positions the character
        this.position = position;
        animations = new HashMap<String, Animation>();

        this.width = width * LevelController.UNIT_SCALE;
        this.height = height  * LevelController.UNIT_SCALE;

        spriteSheet = new Spritesheet("img/aliens.png", width , height);
        currentAnimation = "walk";
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) {
        //draws the SpriteSheet onto the game
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }

    public void update(float deltaTime)
    {
        //animates the character in a direction
        stateTime += deltaTime;
    }
}
