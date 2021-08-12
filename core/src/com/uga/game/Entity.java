package com.uga.game;

import com.badlogic.gdx.math.Rectangle;

public abstract class Entity {
    protected Rectangle position;

    public void setPosition(float x, float y) {
        position = new Rectangle();

        position.x = x;
        position.y = y;
        position.width = 64;
        position.height = 64;
    }
}
