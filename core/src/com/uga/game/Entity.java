package com.uga.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public abstract class Entity extends AnimatedCollider{
    public Entity(){
        super.frames = 8;
    }

    protected Rectangle enemyHitbox;
    public abstract void render(JonasVsArcanaInvaders game);
    public abstract void verifyShot(List<EnemyProjectile> enemyProjectilesOnScreen);

}
