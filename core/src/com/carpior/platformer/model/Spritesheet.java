package com.carpior.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
    public Animation animation;

    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);

        //counts the amount of sprites in the SpriteSheet
        int counter = 0;
        for (int row = 0; row < spriteSheetFrames.length; row++) {
            for (int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
            }

        }

        //creates an array to make space for sprites
        spriteFrames = new TextureRegion[counter];

        //resets counter
        counter = 0;
        //look at the SpriteSheet and take every individual sprite and store it in row
        for (TextureRegion[] row : spriteSheetFrames) {
            //it takes each column and stores it in sprite
            for (TextureRegion sprite : row) {
                //stores sprite into spriteFrames and assigns an= number to each alien
                spriteFrames[counter++] = sprite;
            }
        }
    }
        public Animation createAnimation() {
            //selects the character and its frames
            TextureRegion[] animationFrames = new TextureRegion[2];
            animationFrames[0] = spriteFrames[23];
            animationFrames[1] = spriteFrames[24];
            animation = new Animation(0.2f, animationFrames);
            return animation;
        }
    }
