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
        public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed) {
            //counts the amount of frames we need to use
            int counter = (lastFrame + 1) - startFrame;
            //selects the character and its frames
            TextureRegion[] animationFrames = new TextureRegion[counter];
            for(int index = lastFrame; index >= startFrame; index--) {
                animationFrames[--counter] = spriteFrames[index];
            }
            return new Animation(animationSpeed, animationFrames);
        }

        public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY) {
            //counts the amount of frames
            int frameCount = originalAnimation.getKeyFrames().length;
            TextureRegion[] flippedFrames = new TextureRegion[frameCount];
            //flips the animation of the character
            for(int index = 0; index < frameCount; index++) {
                flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);
                flippedFrames[index].flip(flipX, flipY);
            }
            return new Animation(originalAnimation.getFrameDuration(), flippedFrames);
        }
    }
