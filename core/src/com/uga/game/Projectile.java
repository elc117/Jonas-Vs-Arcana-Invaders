package com.uga.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Projectile extends AnimatedCollider{
    protected static final int hitbox = 32;
    protected Rectangle allyHitbox;
    protected Rectangle enemyHitbox;

    public Projectile(){
        super.frames = 3;
    }

    public abstract void render(SpriteBatch batch);
}
