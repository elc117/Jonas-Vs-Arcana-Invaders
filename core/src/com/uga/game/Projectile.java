package com.uga.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public abstract class Projectile extends AnimatedCollider{
    protected static final int hitboxSize = 16;
    protected Rectangle hitbox;

    public Projectile(){
        super.frames = 3;
        hitbox = new Rectangle();
    }

    public abstract void render(SpriteBatch batch);

}
