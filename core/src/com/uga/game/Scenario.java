package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Scenario {
    private Texture texture;
    private float limit;

    public void setScenario(){
        texture = new Texture("Jonas-Sprite-Sheet.png");
    }

    public void render(Batch batch){
        batch.draw(texture,0,limit);
        limit--;
    }

    public void setLimit(int x){
        this.limit = x;
    }

    public float getLimit() {
        return this.limit;
    }



}
