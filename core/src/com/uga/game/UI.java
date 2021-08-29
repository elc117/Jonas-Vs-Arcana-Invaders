package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UI {
    private Texture background;
    private Texture hearts;
    private Texture powerUpIndicatorFrames;
    private TextureRegion[][] playerHearts;
    private TextureRegion[][] powerUpIndicator;
    private BitmapFont font = new BitmapFont();
    private String playerScore;

    public void setUI(){
        background = new Texture("UI-export.png");
        hearts = new Texture("UI-hearts-export-Sheet.png");
        powerUpIndicatorFrames = new Texture("PowerUpIndicator-Sheet.png");

        playerHearts = TextureRegion.split(hearts,128,hearts.getHeight());
        powerUpIndicator = TextureRegion.split(powerUpIndicatorFrames, 128, 128);
    }

    public void render(JonasVsArcanaInvaders game, Player player) {
        playerScore = String.valueOf(player.getScore());

        game.getBatch().draw(background,0,0);
        game.getBatch().draw(playerHearts[0][player.getHearts()],0,0);
        game.getBatch().draw(powerUpIndicator[0][player.getBuffDuration()*5/100], 0, game.getHeight()/5f );

        font.draw(game.getBatch(), playerScore, 20, game.getHeight() - 540);
    }
}
