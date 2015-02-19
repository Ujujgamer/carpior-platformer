package com.carpior.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicController {
    public static Music music;

    public static void initializeMusicController(){
        music = Gdx.audio.newMusic(Gdx.files.internal("music/VersaceInst.mp3"));
    }

    public static void play(String soundName){
        if (soundName.equalsIgnoreCase("music")){
            music.play();
            music.setLooping(true);
        }
    }
}

