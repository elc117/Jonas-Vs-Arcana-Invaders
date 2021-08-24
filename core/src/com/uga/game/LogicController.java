package com.uga.game;

import java.util.List;

public class LogicController {
    public static void checkScenario(JonasVsArcanaInvaders game, Scenario scenario, Scenario scenario2){
        if(scenario.getLimit() == 0){
            scenario2.setLimit(game.getHeight());
        } else if (scenario2.getLimit() == -2){
            scenario.setLimit(game.getHeight() - 2);
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
                player.setDamage(1);
                enemyProjectilesOnScreen.remove(i);
            } else if (enemyProjectilesOnScreen.get(i).getPosition().y < -64){
                enemyProjectilesOnScreen.remove(i);
            }
        }
    }
}
