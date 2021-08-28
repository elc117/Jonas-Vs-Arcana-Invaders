package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Scenario {
    private Texture texture;
    private float limit;

    public void setScenario(int level){
        switch (level){
            case 2:
                texture = new Texture("Scenarios/CT-export.png");
                break;
            case 3:
                texture = new Texture("Scenarios/RU-export.png");
                break;
            case 4:
                texture = new Texture("Scenarios/Biblioteca-export.png");
                break;
            default:
                texture = new Texture("Scenarios/Avenida-export.png");
                break;
        }
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
