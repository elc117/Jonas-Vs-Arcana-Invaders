package com.uga.game;

public class Bookshelf extends Obstacle{

    public Bookshelf(){
        super.spritesheet = "Obstacles/Bookshelf.png";
        super.frames = 1;
        super.damage = 1;
        super.buff = 2; //isn't buff
        super.spriteSize = 192;
        super.hitboxWidth = 128;
        super.hitboxHeight = 160;
    }


}
