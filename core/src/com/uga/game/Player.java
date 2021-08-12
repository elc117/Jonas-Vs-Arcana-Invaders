package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Player extends Entity{
    public static final int height = 128;
    public static final int width = 128;
    public static final int speed = 200;
    public static final String spritesheet = "Jonas-Spritesheet.png";
    Texture texture;
    private Rectangle position;


    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime;

    public float getx(){
        return position.x;
    }

    public float gety(){
        return position.y;
    }


    public void setAnimation(){
        texture = new Texture(spritesheet);
        TextureRegion[][] tmpFrames = TextureRegion.split(texture,128,128);

        int index = 0;
        int frames = 6;

        animationFrames = new TextureRegion[frames];

        for (int i = 0; i < frames; i++){
            animationFrames[index++] = tmpFrames[0][i];
        }

        animation = new Animation(1f/6f,animationFrames);
    }


    public void render(SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && super.position.x > Player.width) super.position.x -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && super.position.x < Game.width - Player.width) super.position.x += Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && super.position.y > 0) super.position.y -= Player.speed * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && super.position.y < (Game.height - Player.height*2)) super.position.y += Player.speed * Gdx.graphics.getDeltaTime();


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
    }
}
