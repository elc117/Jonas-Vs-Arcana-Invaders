package com.uga.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ScreenAdapter {
    private JonasVsArcanaInvaders game;
    private Player player;
    private int level;

    public GameScreen(JonasVsArcanaInvaders game) {
        this.game = game;
        this.player = game.getPlayer();
        this.level = game.getLevel();
        this.create();
    }

    private void create(){
        this.scenario();
    }

    private List<Entity> enemiesOnScreen = new ArrayList<>();
    private List<AllyProjectile> allyProjectilesOnScreen = new ArrayList<>();
    private List<EnemyProjectile> enemyProjectilesOnScreen = new ArrayList<>();
    private List<Obstacle> obstaclesOnScreen = new ArrayList<>();

    private Scenario scenario = new Scenario();
    private Scenario scenario2 = new Scenario();
    private UI ui = new UI();

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
        if(player.getScore() == 200 * Math.pow(game.getLevel(),2) && game.getBossStatus() != 1){
            game.changeLevel();
        }
    }

    private static void checkScenario(JonasVsArcanaInvaders game, Scenario scenario, Scenario scenario2){
        if(scenario.getLimit() == 0){
            scenario2.setLimit(game.getHeight());
        } else if (scenario2.getLimit() == -256){
            scenario.setLimit(game.getHeight());
        }
    }

    @Override
    public void render (float delta) {
        this.checkGameOver(player);
        this.checkNextLevel(player);
        ScreenUtils.clear(0, 0, 0, 1);
        game.getBatch().begin();

        scenario.render(game.getBatch());
        scenario2.render(game.getBatch());

        ObstacleController.spawn(obstaclesOnScreen, game, level);
        ObstacleController.checkOverlaps(obstaclesOnScreen,game,player);

        EnemyController.spawn(enemiesOnScreen, game);
        EnemyController.checkOverlaps(enemiesOnScreen, game, player, allyProjectilesOnScreen, enemyProjectilesOnScreen);
        this.checkScenario(game, scenario, scenario2);
        ProjectileController.checkProjectiles(game, player, allyProjectilesOnScreen, enemyProjectilesOnScreen);


        player.render(game);
        ui.render(game, player);
        game.getBatch().end();
    }

    @Override
    public void dispose () {
        game.getBatch().dispose();
    }
}
