package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity {
    protected Rectangle position;
    protected Texture texture;
    protected TextureRegion[] animationFrames;
    protected Animation animation;
    protected String spritesheet;
    protected int frames;

    public void setPosition(float x, float y) {
        position = new Rectangle();

        position.x = x;
        position.y = y;
        position.width = 64;
        position.height = 64;
    } //talvez tirar isso daqui, so tem em player, n sei se vai ter nas outras classes filhas

    public float getx(){
        return position.x;
    }

    public float gety(){
        return position.y;
    }

    public void setAnimation(){
        texture = new Texture(spritesheet);
        TextureRegion[][] tmpFrames = TextureRegion.split(texture,128,128);
        //ate agora todas textregion sao 128x128, talvez transformar em variavel futuramente
        int index = 0;
        float fframes = frames;

        animationFrames = new TextureRegion[frames];

        for (int i = 0; i < frames; i++){
            animationFrames[index++] = tmpFrames[0][i];
        }

        animation = new Animation(1f/fframes,animationFrames);
    }

    public abstract void render(SpriteBatch batch);
}
