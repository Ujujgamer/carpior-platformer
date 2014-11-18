package com.carpior.platformer;

import com.badlogic.gdx.Game;
import com.carpior.platformer.view.GameScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        //taking map and displaying it on the screen
        setScreen(new GameScreen());
    }
}
