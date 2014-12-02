package com.carpior.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    //creates a variable for positions
    public Vector2 position;
    //creates a variable for spriteSheets
    public Texture spriteSheet;

    public Player() {
        //positions the character
        position = new Vector2(0, 0);
        //gets a file and saves it as a texture
        spriteSheet = new Texture(Gdx.files.internal("image/aliens.png"));
    }
}
