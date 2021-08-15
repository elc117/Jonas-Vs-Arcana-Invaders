package com.uga.game;

import com.badlogic.gdx.Gdx;

import java.util.List;

public class ProjectileController {
    public static void checkProjectiles(JonasVsArcanaInvaders game, Player player, List<AllyProjectile> allyProjectilesOnScreen, List<EnemyProjectile> enemyProjectilesOnScreen){
        player.verifyShot(allyProjectilesOnScreen);
        for (AllyProjectile allyProjectile : allyProjectilesOnScreen){
            allyProjectile.render(game.batch);
        }
        for (EnemyProjectile enemyProjectile : enemyProjectilesOnScreen){
            enemyProjectile.render(game.batch);
            if(player.allyHitbox.overlaps(enemyProjectile.enemyHitbox)){
                Gdx.app.log("#INFO", "Inimigo matou Player");
                //enemyProjectilesOnScreen.remove(enemyProjectile);
            }
        }
    }
}
