package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Octominion extends Entity{
    float elapsedTime;

    public Octominion(){
        super.spritesheet = "Octominion-Spritesheet.png";
        super.frames = 8;
        super.enemyHitbox = new Rectangle();
    }



    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 64, 64);

        if (super.position.y >= -64){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y -= 3;
        }
    }

    @Override
    public void verifyShot(List<EnemyProjectile> projectilesOnScreen){
        //Precisamos dar um jeito de não usar isso aqui
    }
}
