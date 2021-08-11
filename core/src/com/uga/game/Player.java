package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    Texture texture;

    public void setCharacter(){
        texture = new Texture("Jonas-Sprite-Sheet.png");
    }

    public void render(Rectangle teste){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && teste.x > 128) teste.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && teste.x < 512) teste.x += 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && teste.y > 0) teste.y -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && teste.y < 1024) teste.y += 200 * Gdx.graphics.getDeltaTime();
    }
}
