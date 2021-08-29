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
    private SpriteBatch batch;

    // 0 = Não spawnado; 1 = Spawnado; 2 = Derrotado
    private int bossStatus = 0;

    public SpriteBatch getBatch(){
        return this.batch;
    }

    public int getBossStatus()  { return bossStatus; }

    public void setBossStatus(int status) {bossStatus = status;}

    public int getHeight() {
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getLevel() {return level; }

    public void changeLevel() {
        if (level <= 4){this.level++;}
        this.setScreen(new LevelScreen(this));
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
