package com.carpior.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    //creates a variable for positions
    public Vector2 position;
    //creates a variable for spriteSheets
    public Animation animation;
    public Spritesheet spriteSheet;

    public int width;
    public int height;
    private float stateTime;

    public Player() {
        //positions the character
        position = new Vector2(8,3);
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width , height);
        animation = spriteSheet.createAnimation(9, 10, 0.5f);
        stateTime = 0f;

    }

    public void draw(Batch spriteBatch) {
        //draws the SpriteSheet onto the game
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));
    }

    public void update(float deltaTime)
    {
        //animates the character in a direction
        stateTime += deltaTime;
        position.y += deltaTime;
    }
}
