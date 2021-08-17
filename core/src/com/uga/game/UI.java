package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class UI {
    private Texture texture;
    private BitmapFont font = new BitmapFont();
    private String playerScore;

    public void setBackground(){
        texture = new Texture("UI-export.png");
    }

    public void render(Batch batch, Player player) {
        playerScore = String.valueOf(player.getScore());

        batch.draw(texture,0,0);
        font.draw(batch, playerScore, 20, 484);
    }
}
