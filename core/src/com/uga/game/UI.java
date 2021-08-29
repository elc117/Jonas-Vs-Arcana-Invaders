package com.uga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UI {
    private Texture backgroundsSheet;
    private Texture hearts;
    private Texture powerUpIndicatorFrames;
    private TextureRegion[][] backgrounds;
    private TextureRegion[][] playerHearts;
    private TextureRegion[][] powerUpIndicator;
    private BitmapFont font = new BitmapFont();
    private String playerScore;

    public void setUI(){
        backgroundsSheet = new Texture("UI-Sheet.png");
        hearts = new Texture("UI-hearts-export-Sheet.png");
        powerUpIndicatorFrames = new Texture("PowerUpIndicator-Sheet.png");

        backgrounds = TextureRegion.split(backgroundsSheet, 128, 896);
        playerHearts = TextureRegion.split(hearts,128,hearts.getHeight());
        powerUpIndicator = TextureRegion.split(powerUpIndicatorFrames, 128, 128);
    }

    public void render(JonasVsArcanaInvaders game, Player player) {
        playerScore = String.valueOf(player.getScore());

        // UI correspondente ao level, ou endless mode
        if(game.getLevel() <= 4){ game.getBatch().draw(backgrounds[0][game.getLevel() - 1],0,0);}
        else { game.getBatch().draw(backgrounds[0][4],0,0);}
        game.getBatch().draw(playerHearts[0][player.getHearts()],0,0);
        game.getBatch().draw(powerUpIndicator[0][player.getBuffDuration()*5/100], 0, game.getHeight()/5f );

        font.draw(game.getBatch(), playerScore, 20, game.getHeight() - 540);
    }
}
