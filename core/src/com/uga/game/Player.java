package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Player extends AnimatedCollider{
    private static final int height = 128;
    private static final int width = 128;
    private static int speed = 300;
    float elapsedTime;
    long lastShot = System.currentTimeMillis();
    long buffTime;
    long projectileCoolDown = 400;
    long currentBuffTime;
    protected Rectangle allyHitbox;
    private int score = 0;
    private int hearts = 5;

    public Player(){
        super.spritesheet = "Jonas-Spritesheet.png";
        allyHitbox = new Rectangle();
        super.frames = 6;
    }

    public void setScore(int points){
        this.score += points;
    }

    public int getScore(){
        return score;
    }

    public int getHearts(){
        return this.hearts;
    }

    public void setDamage(int damage){
        this.hearts -= damage;
    }

    public void setBuff(int buff){
        if (buff == 1){
            speed = 450;
            projectileCoolDown = 1;
            currentBuffTime = System.currentTimeMillis();
        }
        if (buff == 2){ //carro desativa o buff
            speed = 300;
            projectileCoolDown = 400;
        }
    }


    public void render(JonasVsArcanaInvaders game){
        elapsedTime += Gdx.graphics.getDeltaTime();

        allyHitbox.set(super.position.x, super.position.y, 64, 64);

        if((Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) && super.position.x > Player.width) {
            super.position.x -= Player.speed * Gdx.graphics.getDeltaTime();
        }
        if((Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) && super.position.x < game.getWidth() - Player.width) {
            super.position.x += Player.speed * Gdx.graphics.getDeltaTime();
        }
        if((Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) && super.position.y > 0) {
            super.position.y -= Player.speed * Gdx.graphics.getDeltaTime();
        }
        if((Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) && super.position.y < (game.getHeight() - Player.height*2)) {
            super.position.y += Player.speed * Gdx.graphics.getDeltaTime();
        }


        game.batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
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
