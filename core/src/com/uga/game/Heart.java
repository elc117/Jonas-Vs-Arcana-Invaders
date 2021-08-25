package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import java.util.List;

public class Heart extends Obstacle{

    public Heart(){
        super.spritesheet = "Health-Sheet.png";
        super.frames = 3;
        super.enemyHitbox = new Rectangle();
        super.damage = -1;
    }

    float elapsedTime;



    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 32, 32);

        batch.draw((TextureRegion) super.animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.position.y -= 2;
    }


}
