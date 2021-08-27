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
    List<Obstacle> obstaclesOnScreen = new ArrayList<>();

    Player player = new Player();
    Scenario scenario = new Scenario();
    Scenario scenario2 = new Scenario();
    UI ui = new UI();

    int level = 3;

    public void scenario1(){
        player.setPosition(game.getWidth()/2f, 200);
        player.setAnimation();

        scenario.setScenario(level);
        scenario2.setScenario(level);
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

        scenario.render(game.batch);
        scenario2.render(game.batch);

        ObstacleController.spawn(obstaclesOnScreen, game, level);
        ObstacleController.checkOverlaps(obstaclesOnScreen,game,player);

        EnemyController.spawn(enemiesOnScreen, game);
        EnemyController.checkOverlaps(enemiesOnScreen, game, player, allyProjectilesOnScreen, enemyProjectilesOnScreen);
        LogicController.checkScenario(game, scenario, scenario2);
        LogicController.checkProjectiles(game, player, allyProjectilesOnScreen, enemyProjectilesOnScreen);

        player.render(game);
        ui.render(game, player);
        game.batch.end();

    }

    @Override
    public void dispose () {
        game.batch.dispose();
    }
}
