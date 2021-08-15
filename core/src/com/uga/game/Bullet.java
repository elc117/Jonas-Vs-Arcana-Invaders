package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
    protected Vector2 position;
    protected Texture texture;
    protected TextureRegion[] animationFrames;
    protected String spritesheet;
    protected Animation animation;
    protected int frames;
    protected Rectangle allyHitbox;
    protected Rectangle enemyHitbox;

    float elapsedTime;

    public void setPosition(float x, float y) {
        position = new Vector2();
        position.x = x;
        position.y = y;
        enemyHitbox = new Rectangle();
    }

    public Vector2 getPosition(){
        return position;
    }

    public void setAnimation(){
        texture = new Texture(spritesheet);
        TextureRegion[][] tmpFrames = TextureRegion.split(texture,128,128);
        //ate agora todas textregion sao 128x128, talvez transformar em variavel futuramente


        frames = 3;
        int index = 0;
        float fframes = frames;

        animationFrames = new TextureRegion[frames];

        for (int i = 0; i < frames; i++){
            animationFrames[index++] = tmpFrames[0][i];
        }

        animation = new Animation(1f/fframes,animationFrames);
    }


    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        allyHitbox.set(position.x, position.y, 64, 64);

        if (position.y <= 1160){//fazer variavel de tamanho pra esse bicho
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), position.x, position.y);
            position.y += 6;
        }
    }
}
