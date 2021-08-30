package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.List;

public class ProjectileController {

    private static Sound playerHurt = Gdx.audio.newSound(Gdx.files.internal("Sounds/playerHurt.wav"));


    public static void checkProjectiles(JonasVsArcanaInvaders game, Player player, List<AllyProjectile> allyProjectilesOnScreen, List<EnemyProjectile> enemyProjectilesOnScreen){
        //controles the projectiles, removing enemies/projectiles or damaging the player
        player.verifyShot(allyProjectilesOnScreen);
        for (int i = 0; i < allyProjectilesOnScreen.size(); i++){
            allyProjectilesOnScreen.get(i).render(game.getBatch());
            if(allyProjectilesOnScreen.get(i).getPosition().y > game.getHeight() + 64){
                allyProjectilesOnScreen.remove(i);
            }
        }
        for (int i = 0; i < enemyProjectilesOnScreen.size(); i++){
            enemyProjectilesOnScreen.get(i).render(game.getBatch());
            if (player.allyHitbox.overlaps(enemyProjectilesOnScreen.get(i).hitbox)){
                playerHurt.play(0.3f);
                player.setHearts(-1);
                enemyProjectilesOnScreen.remove(i);
            } else if (enemyProjectilesOnScreen.get(i).getPosition().y < -64){
                enemyProjectilesOnScreen.remove(i);
            }
        }
    }
}
