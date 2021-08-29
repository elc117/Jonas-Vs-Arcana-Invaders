package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class TitleScreen extends ScreenAdapter {

    private JonasVsArcanaInvaders game;
    private Texture texture;
    public TitleScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        texture = new Texture("Screens/TitleScreen.png");
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
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
