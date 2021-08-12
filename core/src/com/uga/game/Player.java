package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Player implements Entity{
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

    @Override
    public void setPosition(float x, float y){
        position = new Rectangle();

        position.x = x;
        position.y = y;
        position.width = 64;
        position.height = 64;
    }

    @Override
    public void setAnimation(){
        texture = new Texture("Jonas-Spritesheet.png");
        TextureRegion[][] tmpFrames = TextureRegion.split(texture,128,128);

        int index = 0;
        int frames = 6;

        animationFrames = new TextureRegion[frames];

        for (int i = 0; i < frames; i++){
            animationFrames[index++] = tmpFrames[0][i];
        }

        animation = new Animation(1f/6f,animationFrames);
    }

    @Override
    public void render(SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x > 128) position.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.x < 512) position.x += 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y > 0) position.y -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && position.y < 1024) position.y += 200 * Gdx.graphics.getDeltaTime();


        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), position.x, position.y);
    }
}
