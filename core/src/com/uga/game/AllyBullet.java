package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AllyBullet extends Bullet {
    // Preciso fazer funcionar depois
    float elapsedTime;

    public AllyBullet(){
        super.spritesheet = "Bullet-Spritesheet.png";
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 64, 64);

        if (super.position.y <= 1160){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y += 6;
        }
    }
}
