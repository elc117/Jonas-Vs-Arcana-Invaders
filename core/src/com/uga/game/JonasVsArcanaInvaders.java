package com.uga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JonasVsArcanaInvaders extends Game {
    private final int height = 896;
    private final int width = 640;
    SpriteBatch batch;

    public int getHeight() {
        return height;
    }

    public int getWidth(){
        return width;
    }

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
