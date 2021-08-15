package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Player extends AnimatedCollider{
    private static final int height = 128;
    private static final int width = 128;
    private static final int speed = 200;
    float elapsedTime;
    long lastShot = System.currentTimeMillis();
    long projectileCoolDown = 300;
    protected Rectangle allyHitbox;


    public Player(){
        super.spritesheet = "Jonas-Spritesheet.png";
        allyHitbox = new Rectangle();
        super.frames = 6;
    }

    public void render(SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();

        allyHitbox.set(super.position.x, super.position.y, 64, 64);


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && super.position.x > Player.width) super.position.x -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && super.position.x < JonasVsArcanaInvaders.getWidth() - Player.width) super.position.x += Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && super.position.y > 0) super.position.y -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && super.position.y < (JonasVsArcanaInvaders.getHeight() - Player.height*2)) super.position.y += Player.speed * Gdx.graphics.getDeltaTime();


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
    }

    public void verifyShot(List<AllyProjectile> allyProjectilesOnScreen){
        long time = System.currentTimeMillis();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && time > this.lastShot + this.projectileCoolDown){
            AllyProjectile allyProjectile = new AllyProjectile();
            allyProjectile.setPosition(this.position.x, this.position.y);
            allyProjectile.setAnimation();
            this.lastShot = time;
            allyProjectilesOnScreen.add(allyProjectile);
        }
    }
}
