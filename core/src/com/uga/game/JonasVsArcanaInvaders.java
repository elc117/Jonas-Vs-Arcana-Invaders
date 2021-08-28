package com.uga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JonasVsArcanaInvaders extends Game {
    private int height = 896;
    private int width = 640;
    private int level = 1;
    private Player player = new Player();
    public SpriteBatch batch;

    public int getHeight() {
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getLevel() {return level; }

    public void changeLevel() {
        this.level++;
        this.setScreen(new GameScreen(this));
    }

    public Player getPlayer() {return player;}

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new TitleScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }


}
