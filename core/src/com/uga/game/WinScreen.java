package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

public class WinScreen extends ScreenAdapter {
    private JonasVsArcanaInvaders game;
    private Texture texture;
    private BitmapFont font = new BitmapFont();
    private String playerScore;

    public WinScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        texture = new Texture("Screens/WinScreen.png");
        playerScore = String.valueOf(game.getPlayer().getScore());
        game.getInGameMusic().stop();
        game.getMenuMusic().play();
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.getMenuMusic().stop();
                    game.getInGameMusic().play();
                    game.getPlayer().setScore(-1 * game.getPlayer().getScore());
                    game.setScreen(new GameScreen(game));
                }
                if (keyCode == Input.Keys.ESCAPE) {
                    Gdx.app.exit();
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.getBatch().begin();
        game.getBatch().draw(texture,0,0);
        font.draw(game.getBatch(), playerScore, game.getWidth()/2f, game.getHeight()/2f + 80);
        game.getBatch().end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
