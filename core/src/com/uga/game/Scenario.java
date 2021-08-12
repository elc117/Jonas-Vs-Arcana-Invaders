package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Scenario {
    private Texture texture;
    private float limit;

    public void setScenario(){

        texture = new Texture("Avenida-export.png");
    }

    public void render(Batch batch) {
        batch.draw(texture,128,limit);
        limit-=2;
    }

    public void setLimit(int y) {
        this.limit = y;
    }

    public float getLimit() {
        return this.limit;
    }



}
