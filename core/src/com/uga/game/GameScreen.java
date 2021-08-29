package com.uga.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ScreenAdapter {
    JonasVsArcanaInvaders game;
    Player player;
    Boss boss;
    int level;
    boolean spawnedBoss = false;

    public GameScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        this.player = game.getPlayer();
        this.level = game.getLevel();
        this.create();
    }

    private void create(){
        this.scenario();
    }

    List<Entity> enemiesOnScreen = new ArrayList<>();
    List<AllyProjectile> allyProjectilesOnScreen = new ArrayList<>();
    List<EnemyProjectile> enemyProjectilesOnScreen = new ArrayList<>();
    List<Obstacle> obstaclesOnScreen = new ArrayList<>();

    Scenario scenario = new Scenario();
    Scenario scenario2 = new Scenario();
    UI ui = new UI();

    public void scenario(){
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
            game.setScreen(new GameOverScreen(game));
        }
    }

    private void checkNextLevel(Player player){
        if(player.getScore() == 200 * Math.pow(game.getLevel(),2) && game.getLevel() <= 0){
            game.changeLevel();
        } else if(player.getScore() == 200 * Math.pow(game.getLevel(),2) && game.getLevel() == 1 && !spawnedBoss){
            boss = new Boss();
            enemiesOnScreen.add(boss);
            spawnedBoss = true;
        }
    }

    @Override
    public void render (float delta) {
        this.checkGameOver(player);
        this.checkNextLevel(player);
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
