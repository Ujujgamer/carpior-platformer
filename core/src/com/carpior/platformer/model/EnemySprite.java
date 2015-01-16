package com.carpior.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.carpior.platformer.controller.LevelController;

import java.util.HashMap;

public class EnemySprite {
    public Body physicsBody;
    //creates a variable for positions
    public Vector2 position;
    //creates a variable for spriteSheets
    public Spritesheet spriteSheet;
    public String currentAnimation;

    public float width;
    public float height;

    protected float stateTime;
    protected HashMap<String, Animation> animations;

    public EnemySprite(Vector2 position, int width, int height, String sheetPath) {
        //positions the character
        this.position = position;
        animations = new HashMap<String, Animation>();

        this.width = width * LevelController.ENEMY_UNIT_SCALE;
        this.height = height  * LevelController.ENEMY_UNIT_SCALE;

        spriteSheet = new Spritesheet(sheetPath, width , height);
        currentAnimation = "attack";
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
