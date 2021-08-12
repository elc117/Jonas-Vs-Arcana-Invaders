package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Chloroghost extends Entity{
    Texture texture;
    private Rectangle position;

    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime;


    public void setAnimation() {
        texture = new Texture("Chloroghost-Spritesheet.png");
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

        if (this.position.y >= -64){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), position.x, position.y);
            position.y -= 3;
        }
    }
}
