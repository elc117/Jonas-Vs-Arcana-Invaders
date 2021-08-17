package com.uga.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public abstract class Entity extends AnimatedCollider{

    public Entity(){
        super.frames = 6;
    }

    protected Rectangle enemyHitbox;
    public abstract void render(SpriteBatch batch);
    public abstract void verifyShot(List<EnemyProjectile> enemyProjectilesOnScreen);
}
