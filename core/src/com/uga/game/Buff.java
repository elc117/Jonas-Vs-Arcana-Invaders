package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Buff extends Obstacle{

    public Buff(){
        super.spritesheet = "Obstacles/Buff-Sheet.png";
        super.frames = 3;
        super.enemyHitbox = new Rectangle();
        super.damage = 0;
        super.buff = 1;
    }

    float elapsedTime;



    @Override
    public void render(JonasVsArcanaInvaders game) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        enemyHitbox.set(position.x, position.y, 32, 32);

        game.batch.draw((TextureRegion) super.animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.position.y -= 2;
    }

}
