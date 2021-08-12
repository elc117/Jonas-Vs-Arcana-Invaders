package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Bullet extends Entity {
    Texture texture;
    private Rectangle position;

    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime;



    public void setAnimation() {
        texture = new Texture("Bullet-Spritesheet.png");
        TextureRegion[][] tmpFrames = TextureRegion.split(texture,128,128);

        int index = 0;
        int frames = 3;

        animationFrames = new TextureRegion[frames];

        for (int i = 0; i < frames; i++){
            animationFrames[index++] = tmpFrames[0][i];
        }

        animation = new Animation(1f/3f,animationFrames);
    }


    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        if (super.position.y <= 1160){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y += 6;
        }
    }
}
