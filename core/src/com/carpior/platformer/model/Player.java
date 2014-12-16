package com.carpior.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Player {
    //creates a variable for positions
    public Vector2 position;
    //creates a variable for spriteSheets
    public Spritesheet spriteSheet;

    public int width;
    public int height;
    private float stateTime;
    private HashMap<String, Animation> animations;
    public String currentAnimation;

    public Player() {
        //positions the character
        position = new Vector2(14,5);
        animations = new HashMap<String, Animation>();
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width , height);
        animations.put("walk", spriteSheet.createAnimation(9, 10, 0.1f));
        animations.put("walkFlip", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("stand", spriteSheet.createAnimation(0, 0, 0.1f));
        animations.put("climb", spriteSheet.createAnimation(1, 2, 0.2f));
        animations.put("duck", spriteSheet.createAnimation(2, 2, 0.1f));
        animations.put("duckFlip", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("hurtFlip", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("jump", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("jumpFlip", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("idle", spriteSheet.createAnimation(6, 6, 0.1f));
        animations.put("idleFlip", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("swim", spriteSheet.createAnimation(7, 8, 0.2f));
        animations.put("swimFlip", spriteSheet.flipAnimation(animations.get("walk"), true, false));

        currentAnimation = "idle";
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) {
        //draws the SpriteSheet onto the game
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));
    }

    public void update(float deltaTime)
    {
        //animates the character in a direction
        stateTime += deltaTime;
        position.x -= deltaTime;
    }
}
