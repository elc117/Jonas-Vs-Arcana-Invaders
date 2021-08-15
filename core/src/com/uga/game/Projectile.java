package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Projectile extends AnimatedCollider{
    protected static final int hitbox = 64;
    protected Animation animation;
    protected Rectangle allyHitbox;
    protected Rectangle enemyHitbox;//apagar
    float elapsedTime;

    public Projectile(){
        super.frames = 3;
        enemyHitbox = new Rectangle();//apagar
    }

    public void render(SpriteBatch batch) { //fazer virar abstrato
        elapsedTime += Gdx.graphics.getDeltaTime();

        allyHitbox.set(position.x, position.y, hitbox, hitbox);

        if (position.y <= 1160){//fazer variavel de tamanho pra esse bicho
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), position.x, position.y);
            position.y += 6;
        }
    }
}
