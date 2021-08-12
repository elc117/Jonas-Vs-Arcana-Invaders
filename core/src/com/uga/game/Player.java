package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Player<animation> implements Entity{
    Texture texture;

    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime;

    @Override
    public void setCharacter(){
        texture = new Texture("Jonas-Sprite-Sheet.png");
        TextureRegion[][] tmpFrames = TextureRegion.split(texture,128,128);

        animationFrames = new TextureRegion[6];
        int index = 0;

        for (int i = 0; i < 6; i++){
            animationFrames[index++] = tmpFrames[0][i];
        }

        animation = new Animation(1f/6f,animationFrames);
    }

    @Override
    public void render(Rectangle teste, SpriteBatch batch){
        elapsedTime += Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && teste.x > 128) teste.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && teste.x < 512) teste.x += 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && teste.y > 0) teste.y -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && teste.y < 1024) teste.y += 200 * Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), teste.x, teste.y);
    }
}
