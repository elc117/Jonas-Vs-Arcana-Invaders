package com.uga.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.badlogic.gdx.math.Rectangle;

public abstract class Obstacle extends AnimatedCollider{
    protected Rectangle enemyHitbox;
    protected int damage;
    protected int buff = 0;
    public Obstacle(){
        super.frames = 2;
    }
    public abstract void render(SpriteBatch batch);


}
