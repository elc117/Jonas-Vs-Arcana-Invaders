package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public abstract class Entity {
    protected Vector2 position;
    protected Texture texture;
    protected TextureRegion[] animationFrames;
    protected Animation animation;
    protected String spritesheet;
    protected int frames;
    protected Rectangle allyHitbox;
    protected Rectangle enemyHitbox;

    public void setPosition(float x, float y) {
        position = new Vector2();
        position.x = x;
        position.y = y;
    }

    public Vector2 getPosition(){
        return position;
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
    public abstract void verifyShot(List<Bullet> bulletsOnScreen);
}
