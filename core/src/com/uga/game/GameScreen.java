package com.uga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ScreenAdapter {
    JonasVsArcanaInvaders game;
    public GameScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        this.create();
    }

    private void create(){
        this.scenario1();
    }

    public static final int height = 1152;
    public static final int width = 640;

    List<Bullet> bulletsOnScreen = new ArrayList<>();
    long lastShot = 0;
    long bulletCoolDown = 300;

    Player player = new Player();
    Scenario scenario = new Scenario();
    Scenario scenario2 = new Scenario();
    Octominion enemy = new Octominion();
    Octominion enemy2 = new Octominion();
    Chloroghost enemy3 = new Chloroghost();
    UI ui = new UI();



    public void scenario1(){
        player.setPosition(512, 200);
        player.setAnimation();

        enemy.setPosition(512, 1660);
        enemy.setAnimation();

        enemy2.setPosition(400, 1370);
        enemy2.setAnimation();

        enemy3.setPosition(200, 1500);
        enemy3.setAnimation();

        scenario.setScenario();
        scenario2.setScenario();
        scenario.setLimit(GameScreen.height);
        scenario2.setLimit(0);

        ui.setBackground();
    }


    @Override
    public void render (float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.begin();

        ui.render(game.batch);
        scenario.render(game.batch);
        scenario2.render(game.batch);

        enemy.render(game.batch);
        enemy2.render(game.batch);
        enemy3.render(game.batch);

        this.checkScenario();
        this.checkBullet();

        player.render(game.batch);
        game.batch.end();
    }

    private void checkScenario(){
        if(scenario.getLimit() == 0){
            scenario2.setLimit(GameScreen.height);
        } else if (scenario2.getLimit() == -2){
            scenario.setLimit(GameScreen.height - 2);
        }
    }

    private void checkBullet(){
        long time = System.currentTimeMillis();
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && time > lastShot + bulletCoolDown){
            Bullet bullet = new Bullet();
            bullet.setPosition(player.getPosition().x, player.getPosition().y);
            bullet.setAnimation();
            bulletsOnScreen.add(bullet);
            lastShot = time;
        }

        for (Bullet bullet : bulletsOnScreen){
            bullet.render(game.batch);
        }
    }


    @Override
    public void dispose () {
        game.batch.dispose();
    }
}
