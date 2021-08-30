package com.uga.game;

public class Car extends Obstacle{

    public Car(){
        super.spritesheet = "Obstacles/Car-Export.png";
        super.frames = 1;
        super.damage = 1;
        super.buff = 2; //isn't a buff
        super.spriteSize = 192;
        super.hitboxWidth = 128;
        super.hitboxHeight = 160;
    }


}
