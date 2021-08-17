package com.uga.game;

import com.badlogic.gdx.Gdx;

import java.util.List;

public class ProjectileController {
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
                Gdx.app.log("#INFO", "Inimigo matou Player");
                game.setScreen(new TitleScreen(game));
                enemyProjectilesOnScreen.remove(i);
            } else if (enemyProjectilesOnScreen.get(i).getPosition().y < -64){
                enemyProjectilesOnScreen.remove(i);
            }
        }
    }
}
