package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class TitleScreen extends ScreenAdapter {
    JonasVsArcanaInvaders game;
    Texture texture;
    public TitleScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        texture = new Texture("TitleScreen.png");
    }

    @Override
    public void show(){
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.begin();
        game.batch.draw(texture,0,0);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
