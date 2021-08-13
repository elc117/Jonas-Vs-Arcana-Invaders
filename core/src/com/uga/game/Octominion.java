package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Octominion extends Entity{
    float elapsedTime;

    public Octominion(){
        super.spritesheet = "Octominion-Spritesheet.png";
        super.frames = 8;
    }



    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        if (super.position.y >= -64){
            batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
            super.position.y -= 3;
        }
    }
}
