package com.uga.game;

public class Car extends Obstacle{

    public Car(){
        super.spritesheet = "Obstacles/Car-Export.png";
        super.spriteSize = 192;
        super.hitboxWidth = 128;
        super.hitboxHeight = 160;
    }


}
