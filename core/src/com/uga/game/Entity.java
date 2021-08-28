package com.uga.game;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public abstract class Entity extends AnimatedCollider{
    int lifes;
    int damage;
    public Entity(){
        super.frames = 6;
    }

    protected Rectangle enemyHitbox;
    public abstract void render(JonasVsArcanaInvaders game);
    public abstract void verifyShot(List<EnemyProjectile> enemyProjectilesOnScreen);

}
