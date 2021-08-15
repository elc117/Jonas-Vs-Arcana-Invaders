package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AnimatedCollider {
    protected static final int spriteSize = 128;
    protected Vector2 position;
    protected Texture texture;
    protected TextureRegion[] animationFrames;
    protected String spritesheet;
    protected int frames;
    protected Animation animation;

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
        TextureRegion[][] tmpFrames = TextureRegion.split(texture,spriteSize,spriteSize);
        int index = 0;
        float fframes = frames;

        animationFrames = new TextureRegion[frames];

        for (int i = 0; i < frames; i++){
            animationFrames[index++] = tmpFrames[0][i];
        }

        animation = new Animation(1f/fframes,animationFrames);
    }
}
