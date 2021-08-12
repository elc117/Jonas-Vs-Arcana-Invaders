package com.uga.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface Entity {


    public void render(Rectangle teste, SpriteBatch batch);
    public void setCharacter();
}
