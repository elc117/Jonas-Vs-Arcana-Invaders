package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class ComputerTable extends Obstacle{

    public ComputerTable(){
        super.spritesheet = "Obstacles/ComputerTable.png";
        super.spriteSize = 192;
        super.frames = 1;
        super.enemyHitbox = new Rectangle();
        super.damage = 1;
        super.buff = 2;
    }

    float elapsedTime;



    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 128, 160);


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.setMovement(0, 2);
    }


}
