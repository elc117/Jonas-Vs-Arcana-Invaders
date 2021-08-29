package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class FoodTable extends Obstacle{

    public FoodTable(){
        super.spritesheet = "Obstacles/FoodTable.png";
        super.frames = 1;
        super.damage = 1;
        super.buff = 2;
        super.spriteSize = 192;
        super.hitboxWidth = 128;
        super.hitboxHeight = 160;
    }


}
