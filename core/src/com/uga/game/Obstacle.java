package com.uga.game;

public class Obstacle extends AnimatedCollider{

    public Obstacle(){
        super.frames = 2;
    }

    public void collide(Player player){
        player.setDamage(4);
    }


}
