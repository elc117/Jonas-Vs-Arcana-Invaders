package com.uga.game;

public class Buff extends Obstacle{

    public Buff(){
        super.spritesheet = "Obstacles/Buff-Sheet.png";
        super.frames = 3;
        super.damage = 0;
        super.buff = 1; // is a buff
        super.hitboxWidth = 32;
        super.hitboxHeight = 32;
    }
}
