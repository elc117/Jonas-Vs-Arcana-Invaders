package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen extends ScreenAdapter {
    private JonasVsArcanaInvaders game;
    private Texture texture;
    private BitmapFont font = new BitmapFont();
    private String playerScore;

    public GameOverScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        texture = new Texture("Screens/GameOverScreen.png");
        playerScore = String.valueOf(game.getPlayer().getScore());
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    // Caso esteja no endless mode. A pontuação é zerada a cada morte
                    if(game.getLevel() > 4){
                        game.getPlayer().setScore(-1 * game.getPlayer().getScore());
                    } else {
                        // Caso o player morra fora do endlessmode, precisamos garantir que o boss seja "despawnado"
                        game.setBossStatus(0);
                    }
                    game.getPlayer().setHearts(5);
                    game.getPlayer().setBuff(2);
                    game.setScreen(new GameScreen(game));
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
