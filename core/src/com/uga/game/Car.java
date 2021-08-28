package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Car extends Obstacle{

    public Car(){
        super.spritesheet = "Obstacles/Car-Export.png";
        super.spriteSize = 192;
        super.frames = 1;
        super.enemyHitbox = new Rectangle();
        super.damage = 1;
        super.buff = 2; //carro cancela o buff
    }

    float elapsedTime;



    @Override
    public void render(JonasVsArcanaInvaders game) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 128, 160);


        game.batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.setMovement(game,0, 2);
    }


}
