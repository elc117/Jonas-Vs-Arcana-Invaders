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

    List<Entity> enemiesOnScreen = new ArrayList<>();
    List<Bullet> bulletsOnScreen = new ArrayList<>();

    Player player = new Player();
    Scenario scenario = new Scenario();
    Scenario scenario2 = new Scenario();
    UI ui = new UI();



    public void scenario1(){
        player.setPosition(512, 200);
        player.setAnimation();

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

        this.enemySpawner();
        this.checkScenario();
        this.checkBullet();

        player.render(game.batch);
        game.batch.end();

    }

    private void enemySpawner(){
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1)){
            Octominion octominion = new Octominion();
            octominion.setPosition(512, 1660);
            octominion.setAnimation();
            enemiesOnScreen.add(octominion);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_2)){
            Chloroghost chloroghost = new Chloroghost();
            chloroghost.setPosition(400, 1370);
            chloroghost.setAnimation();
            enemiesOnScreen.add(chloroghost);
        }

        for (Entity enemy : enemiesOnScreen){
            enemy.render(game.batch);
            enemy.verifyShot(bulletsOnScreen);
            if(player.allyHitbox.overlaps(enemy.enemyHitbox)) Gdx.app.log("#INFO", "My message.");
            /*for (Bullet bullet : bulletsOnScreen){
                if(enemy.enemyHitbox.overlaps(bullet.allyHitbox)) enemiesOnScreen.remove(enemy);
            }*/
        }

    }
    private void checkScenario(){
        if(scenario.getLimit() == 0){
            scenario2.setLimit(GameScreen.height);
        } else if (scenario2.getLimit() == -2){
            scenario.setLimit(GameScreen.height - 2);
        }
    }

    private void checkBullet(){
        player.verifyShot(bulletsOnScreen);
        for (Bullet bullet : bulletsOnScreen){
            bullet.render(game.batch);
            if(player.allyHitbox.overlaps(bullet.enemyHitbox)) Gdx.app.log("#INFO", "My message.");
        }
    }

    @Override
    public void dispose () {
        game.batch.dispose();
    }
}
