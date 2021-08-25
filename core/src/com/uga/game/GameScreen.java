package com.uga.game;

import com.badlogic.gdx.ScreenAdapter;
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


    List<Entity> enemiesOnScreen = new ArrayList<>();
    List<AllyProjectile> allyProjectilesOnScreen = new ArrayList<>();
    List<EnemyProjectile> enemyProjectilesOnScreen = new ArrayList<>();

    Player player = new Player();
    Scenario scenario = new Scenario();
    Scenario scenario2 = new Scenario();
    UI ui = new UI();



    public void scenario1(){
        player.setPosition(game.getWidth() / 2, 200);
        player.setAnimation();

        scenario.setScenario();
        scenario2.setScenario();
        scenario.setLimit(game.getHeight());
        scenario2.setLimit(0);

        ui.setUI();
    }

    private void checkGameOver(Player player){
        if(player.getHearts() <= 0){
            game.setScreen(new GameOver(game, 0, player));
        }
    }


    @Override
    public void render (float delta) {
        this.checkGameOver(player);
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.begin();

        ui.render(game, player);
        scenario.render(game.batch);
        scenario2.render(game.batch);

        EnemyController.spawn(enemiesOnScreen, game, player, allyProjectilesOnScreen, enemyProjectilesOnScreen);
        EnemyController.checkOverlaps(enemiesOnScreen, game, player, allyProjectilesOnScreen, enemyProjectilesOnScreen);
        LogicController.checkScenario(game, scenario, scenario2);
        LogicController.checkProjectiles(game, player, allyProjectilesOnScreen, enemyProjectilesOnScreen);

        player.render(game);
        game.batch.end();

    }

    @Override
    public void dispose () {
        game.batch.dispose();
    }
}
