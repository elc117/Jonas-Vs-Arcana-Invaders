package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Chloroghost extends Entity{
    float elapsedTime;
    long lastShot = 0;
    long projectileCoolDown = 2000;

    public Chloroghost(){
        super.frames = 3;
        super.spritesheet = "Chloroghost-Spritesheet.png";
        super.enemyHitbox = new Rectangle();
        super.lifes = 2;
    }


    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 64, 64);


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.setMovement(2, 3);

    }

    @Override
    public void verifyShot(List<EnemyProjectile> projectilesOnScreen){
        long time = System.currentTimeMillis();
        if(time > lastShot + projectileCoolDown){
            EnemyProjectile enemyprojectile = new EnemyProjectile();
            enemyprojectile.setPosition(position.x, position.y);
            enemyprojectile.setAnimation();
            lastShot = time;
            projectilesOnScreen.add(enemyprojectile);
        }
    }
}
