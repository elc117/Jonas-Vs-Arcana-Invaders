package com.uga.game;

import com.badlogic.gdx.Gdx;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle extends AnimatedCollider{
    protected Rectangle hitbox;
    protected int damage;
    protected int buff = 0;
    float elapsedTime;
    protected int hitboxWidth;
    protected int hitboxHeight;
    public Obstacle(){
        frames = 1;
        hitbox = new Rectangle();
        damage = 1;
        buff = 2;
    }


    public void render(JonasVsArcanaInvaders game) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        hitbox.set(position.x, position.y, hitboxWidth, hitboxHeight);


        game.batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.setMovement(game,0, 2);
    }


}
