package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class Player extends AnimatedCollider{
    private static final int height = 128;
    private static final int width = 128;
    private static int speed = 300;
    private float elapsedTime;
    private long lastShot = System.currentTimeMillis();
    private long projectileCoolDown = 300;
    private long lastDamage = 0;
    private long damageCoolDown = 1000; //invencibility after get damage
    private long buffTime = 3000;
    private long currentBuffTime = 0;
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

    public void setHearts(int health){ //player gets damage or heal
        long time = System.currentTimeMillis();
        if (health >= 0){
            this.hearts += health;
        } else if(health < 0 && time > this.lastDamage + this.damageCoolDown){
            this.hearts += health;
            lastDamage = time;
        }
    }

    public void setBuff(int buff){ //player receives a buff
        if (buff == 1){
            speed = 450;
            projectileCoolDown = 150;
            currentBuffTime = System.currentTimeMillis();
        }
        if (buff == 2){ //carro desativa o buff
            speed = 300;
            projectileCoolDown = 300;
        }
    }

    public int getBuffDuration(){
        long time = System.currentTimeMillis();
        float remainingTime = buffTime + (currentBuffTime - time);
        if (remainingTime > 0){
            int remainingPercentage = (int) (100 * remainingTime / buffTime);
            return remainingPercentage;
        } else {
            return 0;
        }
    }

    public void render(JonasVsArcanaInvaders game){
        //controls player movement and damage effect
        long time = System.currentTimeMillis();
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

        if (time < this.lastDamage + this.damageCoolDown){
            super.spritesheet = "Jonas-Hurt-Sheet.png";
        } else {
            super.spritesheet = "Jonas-Spritesheet.png";
        }
        this.setAnimation();

        game.getBatch().draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
    }

    public void verifyShot(List<AllyProjectile> allyProjectilesOnScreen){
        //player creates new projectile
        long time = System.currentTimeMillis();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && time > this.lastShot + this.projectileCoolDown){
            AllyProjectile allyProjectile = new AllyProjectile();
            allyProjectile.setPosition(this.position.x, this.position.y);
            allyProjectile.setAnimation();
            this.lastShot = time;
            allyProjectilesOnScreen.add(allyProjectile);
        }


        if(time > currentBuffTime + buffTime){
            this.setBuff(2);
        }
    }
}
