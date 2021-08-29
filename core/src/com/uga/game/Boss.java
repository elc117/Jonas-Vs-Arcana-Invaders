package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Boss extends Entity{
    private int lastTime;
    private float elapsedTime;
    private long lastShot = 0;
    private long projectileCoolDown = 4000;
    private int projectilesUsed = 0;

    public Boss(){
        super.spritesheet = "Boss-Spritesheet.png";
        super.enemyHitbox = new Rectangle();
        super.spriteSize = 256;
        super.lifes = 100;
    }



    @Override
    public void render(JonasVsArcanaInvaders game) {
            elapsedTime += Gdx.graphics.getDeltaTime();

            enemyHitbox.set(position.x, position.y, 128, 128);


            game.batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.setMovement(game,5, 0);
    }

    @Override
    public void verifyShot(List<EnemyProjectile> projectilesOnScreen) {
        long time = System.currentTimeMillis();
        if(time > lastShot + projectileCoolDown){
            EnemyProjectile enemyprojectile = new EnemyProjectile();
            enemyprojectile.setPosition(position.x, position.y);
            enemyprojectile.setAnimation();
            lastShot = time;
            projectilesOnScreen.add(enemyprojectile);
            if(projectilesUsed == 0){
                projectileCoolDown = 100;
            }
            projectilesUsed++;
            if (projectilesUsed == 10){
                projectileCoolDown = 2000;
                projectilesUsed = 0;
            }
        }
    }
}
