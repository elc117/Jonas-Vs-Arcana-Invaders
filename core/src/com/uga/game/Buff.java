package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Buff extends Obstacle{

    public Buff(){
        super.spritesheet = "Obstacles/Buff-Sheet.png";
        super.frames = 3;
        super.hitbox = new Rectangle();
        super.damage = 0;
        super.buff = 1;
        super.hitboxWidth = 32;
        super.hitboxHeight = 32;
    }
}
