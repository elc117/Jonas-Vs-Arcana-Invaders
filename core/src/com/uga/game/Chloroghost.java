package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class Chloroghost extends Entity{
    float elapsedTime;
    long lastShot = 0;
    long bulletCoolDown = 1500;

    public Chloroghost(){
        super.frames = 3;
        super.spritesheet = "Chloroghost-Spritesheet.png";
        super.enemyHitbox = new Rectangle();
    }


    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 64, 64);

        if (super.position.y >= -64){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y -= 3;
        }
    }

    @Override
    public void verifyShot(List<Bullet> bulletsOnScreen){
        long time = System.currentTimeMillis();
        if(time > lastShot + bulletCoolDown){
            EnemyBullet enemyBullet = new EnemyBullet();
            enemyBullet.setPosition(position.x, position.y);
            enemyBullet.setAnimation();
            lastShot = time;
            bulletsOnScreen.add(enemyBullet);
        }
    }
}
