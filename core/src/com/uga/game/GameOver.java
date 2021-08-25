package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOver extends ScreenAdapter {
    JonasVsArcanaInvaders game;
    Texture texture;
    int currentScreen;
    private BitmapFont font = new BitmapFont();
    private String playerScore;

    public GameOver(JonasVsArcanaInvaders game, int currentScreen, Player player) {
        this.game = game;
        texture = new Texture("GameOverScreen.png");
        this.currentScreen = currentScreen;
        playerScore = String.valueOf(player.getScore());
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.begin();
        game.batch.draw(texture,0,0);
        font.draw(game.batch, playerScore, game.getWidth()/2f, game.getHeight()/2f + 80);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
