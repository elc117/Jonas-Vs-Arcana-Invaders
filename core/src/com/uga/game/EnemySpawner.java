package com.uga.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.List;

public class EnemySpawner {

    public static void spawn(List<Entity> enemiesOnScreen, JonasVsArcanaInvaders game, Player player, List<AllyProjectile> allyProjectilesOnScreen, List<EnemyProjectile> enemyProjectilesOnScreen){ //arrumar esse crime depois
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

        for (int i = 0; i < enemiesOnScreen.size(); i++){
            enemiesOnScreen.get(i).render(game.batch);
            enemiesOnScreen.get(i).verifyShot(enemyProjectilesOnScreen);
            if(player.allyHitbox.overlaps(enemiesOnScreen.get(i).enemyHitbox)){
                Gdx.app.log("#INFO", "Inimigo matou Player");
            }
            for (int j = 0; j < allyProjectilesOnScreen.size(); j++){
                if(enemiesOnScreen.get(i).enemyHitbox.overlaps(allyProjectilesOnScreen.get(j).allyHitbox)) {
                    enemiesOnScreen.remove(i);
                    allyProjectilesOnScreen.remove(j);
                }
            }
        }
    }
}
