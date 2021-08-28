package com.uga.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class FirstHistory extends ScreenAdapter{
    JonasVsArcanaInvaders game;
    private BitmapFont font = new BitmapFont();
    long fontLastWrite = System.currentTimeMillis();
    int writeControl = 0;
    int skipLine = 0;
    int arrayPosition = 0;
    int drawx = 100, drawy = 100;
    Texture texture;
    String history = "Tudo aconteceu em um dia que parecia normal. Jonas estava indo para a universidade quando avistou vários alunos correndo para fora do campus. Confuso, Jonas percebeu um velho senhor ajoelhado em meio à multidão...";
    List<String> receiveHistory = new ArrayList<>();
    public FirstHistory(JonasVsArcanaInvaders game){
        this.game = game;
        texture = new Texture("LevelImages.png");
        receiveHistory.add("");
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

    private boolean verifyDraw(){
        long current = System.currentTimeMillis();
        if (current > fontLastWrite + 200){
            fontLastWrite = current;
            return true;
        }
        return false;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.begin();
        //game.batch.draw(texture,0,0);
        if (this.verifyDraw()) {
            receiveHistory.set(arrayPosition, receiveHistory.get(arrayPosition) + history.charAt(writeControl));
            writeControl++;
            skipLine++;
            if (skipLine >= 40){
                skipLine = 0;
                receiveHistory.add("");
                arrayPosition++;
            }
        }
        for(int i = 0; i <= arrayPosition; i++) {
            font.draw(game.batch, receiveHistory.get(i), drawx, drawy - i*20);
        }
        game.batch.draw(texture,128,384);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}