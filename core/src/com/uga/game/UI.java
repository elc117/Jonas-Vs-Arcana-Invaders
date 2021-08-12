package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class UI {
    private Texture texture;

    public void setBackground(){
        texture = new Texture("UI-export.png");
    }

    public void render(Batch batch) {
        batch.draw(texture,0,0);
    }
}
