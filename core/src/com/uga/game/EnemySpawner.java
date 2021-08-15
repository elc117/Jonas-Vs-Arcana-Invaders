package com.uga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.List;

public class EnemySpawner {

    public static void spawn(List<Entity> enemiesOnScreen, JonasVsArcanaInvaders game, Player player, List<Projectile> projectilesOnScreen){ //arrumar esse crime depois
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
            enemy.verifyShot(projectilesOnScreen);
            if(player.allyHitbox.overlaps(enemy.enemyHitbox)) Gdx.app.log("#INFO", "My message.");
            /*for (Projectile projectile : projectilesOnScreen){
                if(enemy.enemyHitbox.overlaps(projectile.allyHitbox)) enemiesOnScreen.remove(enemy);
            }*/
        }
    }
}
