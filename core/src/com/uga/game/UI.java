package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UI {
    private Texture background;
    private Texture hearts;
    private TextureRegion[][] playerHearts;
    private BitmapFont font = new BitmapFont();
    private String playerScore;

    public void setUI(){
        background = new Texture("UI-export.png");
        hearts = new Texture("UI-hearts-export-Sheet.png");
        playerHearts = TextureRegion.split(hearts,128,hearts.getHeight());

    }

    public void render(JonasVsArcanaInvaders game, Player player) {
        playerScore = String.valueOf(player.getScore());

        game.batch.draw(background,0,0);
        game.batch.draw(playerHearts[0][player.getHearts()],0,0);

        font.draw(game.batch, playerScore, 20, game.getHeight() - 540);
    }
}
