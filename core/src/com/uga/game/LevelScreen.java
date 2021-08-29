package com.uga.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class LevelScreen extends ScreenAdapter{
    private JonasVsArcanaInvaders game;

    private static Sound letter = Gdx.audio.newSound(Gdx.files.internal("Sounds/letters.wav"));
    private float volume = 1;

    private BitmapFont font = new BitmapFont();
    private long fontLastWrite = System.currentTimeMillis();
    private int writeControl = 0;
    private int skipLine = 0;
    private int arrayPosition = 0;
    private int drawx = 64, drawy = 448;

    private int textSpeed = 100; // Tempo em milissegundos, quanto menor, mais rapido

    private Texture levelImages;
    private TextureRegion levelImage[][];

    private String[] history = new String[5];
    private List<String> receiveHistory = new ArrayList<>();


    public LevelScreen(JonasVsArcanaInvaders game){
        this.history[0] = "Jonas estava indo para a universidade quando avistou vários alunos correndo para fora do campus. Confuso, Jonas percebeu um velho senhor caído em meio à multidão." +
                "Jonas imediatamente foi ajudá-lo. O velho revelou ser um antigo sábio da dimensão de Arcana, invadida por monstros que desejavam instaurar a ignorância. Ele veio para nosso mundo tentar impedir que a Terra tivesse o mesmo destino...  " +
                "Com um último sacrifício, o ancião transferiu para Jonas seu poder, a única fonte de poder capaz de destruir os monstros de Arcana. O conhecimento. Jonas, impelido por sua coragem e determinação, adentrou o campus, com o objetivo de expurgar os invasores.";
        this.history[1] = "Após abrir caminho para a evacuação do local, e aprender a controlar os poderes, Jonas ouviu gritos de socorro vindos do Centro de Tecnologia. Nosso herói não pensou duas vezes e adentrou o local...";
        this.history[2] = "Após resgatar os alunos presos no prédio, Jonas se lembrou de que não havia tomado café da manhã. Convenientemente, nosso herói se encontrava a poucos passos do Restaurante Universitário...";
        this.history[3] = "Após chutar alguns monstros e degustar uma deliciosa carne de panela, Jonas decidiu dar um basta nesta invasão, e rumou em direção ao foco dos invasores, o epicentro do conhecimento... A Biblioteca Central!";
        this.history[4] = "Sem acreditar que havia chegado ao fim, Jonas retornou triunfante para a entrada do campus. Havia saído de casa como um simples aluno, mas hoje, retornou como um herói!";
        this.game = game;
        levelImages = new Texture("LevelImages.png");
        levelImage = TextureRegion.split(levelImages,384,256);
        receiveHistory.add("");
        font.getData().setScale(1.5f);
    }


    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    if (verifyNullPointer()){
                        textSpeed = 0;
                        volume = 0;
                    } else {
                        if(game.getLevel() == 5){
                            game.setScreen(new WinScreen(game));
                        } else {
                            game.setScreen(new GameScreen(game));
                        }
                    }
                }
                return true;
            }
        });
    }

    private boolean verifyNullPointer(){
        if (writeControl < history[game.getLevel()-1].length()){
            return true;
        }
        return false;
    }

    private boolean verifyDraw(){
        long current = System.currentTimeMillis();
        if (current > fontLastWrite + textSpeed){
            fontLastWrite = current;
            return true;
        }
        return false;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.getBatch().begin();
        if (this.verifyDraw() && this.verifyNullPointer()) {
            char character = history[game.getLevel()-1].charAt(writeControl);
            if (character != ' ') {
                letter.play(volume);
            }
            receiveHistory.set(arrayPosition, receiveHistory.get(arrayPosition) + character);
            skipLine++;
            if (skipLine >= 45 && character == ' '){
                skipLine = 0;
                receiveHistory.add("");
                arrayPosition++;
            }
            writeControl++;
        }
        for(int i = 0; i <= arrayPosition; i++) {
            font.draw(game.getBatch(), receiveHistory.get(i), drawx, drawy - i*24);
        }
        game.getBatch().draw(levelImage[0][game.getLevel() - 1],128,512);
        game.getBatch().end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
