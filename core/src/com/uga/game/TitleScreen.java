package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class TitleScreen extends ScreenAdapter {

    private JonasVsArcanaInvaders game;
    private Texture texture;

    public TitleScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        texture = new Texture("Screens/TitleScreen.png");
        game.getMenuMusic().setVolume(0.3f);
        game.getMenuMusic().setLooping(true);
        game.getInGameMusic().setVolume(0.3f);
        game.getInGameMusic().setLooping(true);
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
                    game.setScreen(new LevelScreen(game));
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
        game.getBatch().end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
