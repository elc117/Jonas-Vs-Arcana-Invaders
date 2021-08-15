package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public abstract class Entity extends AnimatedCollider{

    public Entity(){
        super.frames = 6;
    }

    protected Rectangle allyHitbox;
    protected Rectangle enemyHitbox;
    public abstract void render(SpriteBatch batch);
    public abstract void verifyShot(List<Projectile> projectilesOnScreen);
}
