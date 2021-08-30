package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Octominion extends Entity{
    private float elapsedTime;

    public Octominion(){
        super.spritesheet = "Octominion-Spritesheet.png";
        super.enemyHitbox = new Rectangle();
        if (Math.random() > 0.5){ //random initial x direction
            super.direction = 1;
        }
        else{
            super.direction = -1;
        }
    }



    @Override
    public void render(JonasVsArcanaInvaders game) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 64, 64);


        game.getBatch().draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.setMovement(game,2, 5);
    }


    @Override
    public void verifyShot(List<EnemyProjectile> projectilesOnScreen){
        //well, we broke an OO principle
    }
}
