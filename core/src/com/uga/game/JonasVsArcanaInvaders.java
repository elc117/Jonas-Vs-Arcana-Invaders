package com.uga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JonasVsArcanaInvaders extends Game {
    private static final int height = 1152;
    private static final int width = 640;
    Texture texture;
    SpriteBatch batch;

    public static int getHeight() {
        return height;
    }

    public static int getWidth(){
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
