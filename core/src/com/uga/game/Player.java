package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Entity{
    public static final int height = 128;
    public static final int width = 128;
    public static final int speed = 200;
    float elapsedTime;

    public Player(){
        super.frames = 6;
        super.spritesheet = "Jonas-Spritesheet.png";
    }





    public void render(SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && super.position.x > Player.width) super.position.x -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && super.position.x < JonasVsArcanaInvaders.width - Player.width) super.position.x += Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && super.position.y > 0) super.position.y -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && super.position.y < (JonasVsArcanaInvaders.height - Player.height*2)) super.position.y += Player.speed * Gdx.graphics.getDeltaTime();


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
    }
}
