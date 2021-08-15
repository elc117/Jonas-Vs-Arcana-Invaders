package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class EnemyProjectile extends Projectile {
    // Preciso fazer funcionar depois
    float elapsedTime;

    public EnemyProjectile(){
        super.enemyHitbox = new Rectangle();
        super.spritesheet = "EnemyProjectile-Spritesheet.png";
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, super.hitbox, super.hitbox);

        if (super.position.y >= 0){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y -= 6;
        }
    }
}
