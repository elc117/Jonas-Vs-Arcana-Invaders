package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.List;

public class LogicController {

    private static Sound playerHurt = Gdx.audio.newSound(Gdx.files.internal("Sounds/playerHurt.wav"));

    public static void checkScenario(JonasVsArcanaInvaders game, Scenario scenario, Scenario scenario2){
        if(scenario.getLimit() == 0){
            scenario2.setLimit(game.getHeight());
        } else if (scenario2.getLimit() == -256){
            scenario.setLimit(game.getHeight());
        }
    }

    public static void checkProjectiles(JonasVsArcanaInvaders game, Player player, List<AllyProjectile> allyProjectilesOnScreen, List<EnemyProjectile> enemyProjectilesOnScreen){
        player.verifyShot(allyProjectilesOnScreen);
        for (int i = 0; i < allyProjectilesOnScreen.size(); i++){
            allyProjectilesOnScreen.get(i).render(game.batch);
            if(allyProjectilesOnScreen.get(i).getPosition().y > game.getHeight() + 64){
                allyProjectilesOnScreen.remove(i);
            }
        }
        for (int i = 0; i < enemyProjectilesOnScreen.size(); i++){
            enemyProjectilesOnScreen.get(i).render(game.batch);
            if (player.allyHitbox.overlaps(enemyProjectilesOnScreen.get(i).enemyHitbox)){
                playerHurt.play();
                player.setHearts(-1);
                enemyProjectilesOnScreen.remove(i);
            } else if (enemyProjectilesOnScreen.get(i).getPosition().y < -64){
                enemyProjectilesOnScreen.remove(i);
            }
        }
    }
}
