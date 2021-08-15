package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Player extends Entity{
    private static final int height = 128;
    private static final int width = 128;
    private static final int speed = 200;
    float elapsedTime;
    long lastShot = 0;
    long projectileCoolDown = 300;

    public Player(){
        super.spritesheet = "Jonas-Spritesheet.png";
        super.allyHitbox = new Rectangle();
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

    @Override
    public void verifyShot(List<Projectile> projectilesOnScreenOnScreen){
        long time = System.currentTimeMillis();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && time > this.lastShot + this.projectileCoolDown){
            Projectile projectile = new AllyProjectile();
            projectile.setPosition(this.position.x, this.position.y);
            projectile.setAnimation();
            this.lastShot = time;
            projectilesOnScreenOnScreen.add(projectile);
        }
    }
}
