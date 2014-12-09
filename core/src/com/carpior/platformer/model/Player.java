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
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;

    public Animation animation;
    private float stateTime;

    public Player() {
        //positions the character
        position = new Vector2(8,3);
        //gets a file and saves it as a texture
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));

        //sets the amount of rows and columns in the 2D array and splits the sprites from the SpriteSheet
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);

        //counts the amount of sprites in the SpriteSheet
        int counter = 0;
        for(int row = 0; row < spriteSheetFrames.length; row++) {
            for(int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
            }

        }

        //creates an array to make space for sprites
        spriteFrames = new TextureRegion[counter];

        //resets counter
        counter = 0;
        //look at the SpriteSheet and take every individual sprite and store it in row
        for(TextureRegion[] row : spriteSheetFrames) {
            //it takes each column and stores it in sprite
            for(TextureRegion sprite : row) {
                //stores sprite into spriteFrames and assigns an= number to each alien
                spriteFrames[counter++] = sprite;
            }
        }

        //selects the character and its frames
        TextureRegion[] animationFrames = new TextureRegion[2];
        animationFrames[0] = spriteFrames[23];
        animationFrames[1] = spriteFrames[24];
        animation = new Animation(0.2f, animationFrames);

        stateTime = 0f;

    }

    public void draw(Batch spriteBatch) {
        //draws the SpriteSheet onto the game
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));
    }

    public void update(float deltaTime)
    {
        //animates the character in a direction
        stateTime += deltaTime;
        position.y += deltaTime;
    }
}
