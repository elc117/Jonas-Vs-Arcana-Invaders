package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AllyProjectile extends Projectile {
    // Preciso fazer funcionar depois
    float elapsedTime;

    public AllyProjectile(){
        super.spritesheet = "Projectile-Spritesheet.png";
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, super.hitbox, super.hitbox);

        if (super.position.y <= 1160){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y += 6;
        }
    }
}
