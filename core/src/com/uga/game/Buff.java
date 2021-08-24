package com.uga.game;

public class Buff extends AnimatedCollider{



    public void getBuff(Player player){
        player.setDamage(-2);
    }

    public Buff() {
        super.frames = 2;
    }

}
