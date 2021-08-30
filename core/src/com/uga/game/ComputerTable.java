package com.uga.game;


public class ComputerTable extends Obstacle{

    public ComputerTable(){
        super.spritesheet = "Obstacles/ComputerTable.png";
        super.frames = 1;
        super.damage = 1;
        super.buff = 2; //isn't a buff
        super.spriteSize = 192;
        super.hitboxWidth = 128;
        super.hitboxHeight = 160;
    }




}
