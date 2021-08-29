package com.uga.game;


public class Heart extends Obstacle{

    public Heart(){
        super.spritesheet = "Obstacles/Health-Sheet.png";
        super.frames = 3;
        super.damage = -1;
        super.hitboxWidth = 32;
        super.hitboxHeight = 32;
    }


}
