package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Projectile extends AnimatedCollider{
    protected static final int hitbox = 64;
    protected Rectangle allyHitbox;
    protected Rectangle enemyHitbox;

    public Projectile(){
        super.frames = 3;
    }

    public abstract void render(SpriteBatch batch);
}
