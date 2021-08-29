package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Boss extends Entity{
    private float elapsedTime;
    private long lastShot = 0;
    private long projectileCoolDown = 4000;
    private int projectilesUsed = 0;
    private int healthPoints = 15;

    public Boss(){
        super.spritesheet = "Boss-Spritesheet.png";
        super.enemyHitbox = new Rectangle();
        if (Math.random() > 0.5){
            super.direction = 1;
        }
        else{
            super.direction = -1;
        }
        super.spriteSize = 256;
    }

    public void changeHealthPoints(){
        this.healthPoints--;
    }

    public int getHealthPoints(){
        return this.healthPoints;
    }

    @Override
    public void render(JonasVsArcanaInvaders game) {
            elapsedTime += Gdx.graphics.getDeltaTime();

            super.enemyHitbox.set(position.x, position.y, 64, 64);

            game.getBatch().draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), position.x, position.y);

            if (position.y <= game.getHeight() - this.spriteSize){
                super.setMovement(game,2, 0);
            } else {
                super.setMovement(game,2, 1);
            }
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
            if (projectilesUsed == 3){
                projectileCoolDown = 2000;
                projectilesUsed = 0;
            }
        }
    }
}
