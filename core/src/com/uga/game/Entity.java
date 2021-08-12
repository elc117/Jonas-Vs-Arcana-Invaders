package com.uga.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface Entity {
    public void setPosition(float x, float y);
    public void setAnimation();

    public void render(SpriteBatch batch);
}
