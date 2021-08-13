package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnemyBullet extends Bullet {
    // Preciso fazer funcionar depois
    float elapsedTime;

    public EnemyBullet(){
        super.spritesheet = "EnemyBullet-Spritesheet.png";
        super.frames = 3;
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        if (super.position.y <= 1160){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y -= 6;
        }
    }
}
