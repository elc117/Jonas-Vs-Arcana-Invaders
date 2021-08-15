package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class Player extends Entity{
    public static final int height = 128;
    public static final int width = 128;
    public static final int speed = 200;
    float elapsedTime;
    long lastShot = 0;
    long bulletCoolDown = 300;

    public Player(){
        super.frames = 6;
        super.spritesheet = "Jonas-Spritesheet.png";
        super.allyHitbox = new Rectangle();
    }


    public void render(SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();

        allyHitbox.set(super.position.x, super.position.y, 64, 64);


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && super.position.x > Player.width) super.position.x -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && super.position.x < JonasVsArcanaInvaders.width - Player.width) super.position.x += Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && super.position.y > 0) super.position.y -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && super.position.y < (JonasVsArcanaInvaders.height - Player.height*2)) super.position.y += Player.speed * Gdx.graphics.getDeltaTime();


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
    }

    @Override
    public void verifyShot(List<Bullet> bulletsOnScreen){
        long time = System.currentTimeMillis();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && time > this.lastShot + this.bulletCoolDown){
            Bullet bullet = new AllyBullet();
            bullet.setPosition(this.position.x, this.position.y);
            bullet.setAnimation();
            this.lastShot = time;
            bulletsOnScreen.add(bullet);
        }
    }
}
