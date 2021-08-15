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

    public static final int height = 1152;
    public static final int width = 640;

    List<Entity> enemiesOnScreen = new ArrayList<>();
    List<Projectile> projectilesOnScreen = new ArrayList<>();

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

        EnemySpawner.spawn(enemiesOnScreen, game, player, projectilesOnScreen);
        ScenarioController.checkScenario(scenario, scenario2);
        ProjectileController.checkProjectiles(player, projectilesOnScreen);

        player.render(game.batch);
        game.batch.end();

    }



    @Override
    public void dispose () {
        game.batch.dispose();
    }
}
