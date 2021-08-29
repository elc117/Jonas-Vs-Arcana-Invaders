package com.uga.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.List;

public class EnemyController {
    static long lastEnemy = System.currentTimeMillis();
    static final long enemyCoolDown = 300;

    private static Sound playerHurt = Gdx.audio.newSound(Gdx.files.internal("Sounds/playerHurt.wav"));
    private static Sound enemyHurt = Gdx.audio.newSound(Gdx.files.internal("Sounds/enemyHurt.wav"));

    public static void spawn(List<Entity> enemiesOnScreen, JonasVsArcanaInvaders game){
        long time = System.currentTimeMillis();
        if (enemiesOnScreen.size() < 5 + game.getLevel()*2 && time > lastEnemy + enemyCoolDown){
            int enemyType = (int) ((Math.random() * 10) % 3);
            int enemyX = (int) ((Math.random() * 384) + 128);
            if (enemyType == 0){
                Octominion octominion = new Octominion();
                octominion.setPosition(enemyX, game.getHeight() + 128);
                octominion.setAnimation();
                enemiesOnScreen.add(octominion);
            } else if (enemyType == 1){
                Chloroghost chloroghost = new Chloroghost();
                chloroghost.setPosition(enemyX, game.getHeight() + 64);
                chloroghost.setAnimation();
                enemiesOnScreen.add(chloroghost);
            }
            lastEnemy = time;
        }
    }

    public static void checkOverlaps(List<Entity> enemiesOnScreen, JonasVsArcanaInvaders game, Player player, List<AllyProjectile> allyProjectilesOnScreen, List<EnemyProjectile> enemyProjectilesOnScreen){
        for (int i = 0; i < enemiesOnScreen.size(); i++){
            enemiesOnScreen.get(i).render(game);
            enemiesOnScreen.get(i).verifyShot(enemyProjectilesOnScreen);
            if(player.allyHitbox.overlaps(enemiesOnScreen.get(i).enemyHitbox)){
                playerHurt.play();
                enemiesOnScreen.remove(i);
                player.setHearts(-1);
                continue;
            }
            if(enemiesOnScreen.get(i).getPosition().y <= -64){
                enemiesOnScreen.remove(i);
                continue;
            }
            for (int j = 0; j < allyProjectilesOnScreen.size(); j++){
                if(enemiesOnScreen.get(i).enemyHitbox.overlaps(allyProjectilesOnScreen.get(j).allyHitbox)) {
                    enemyHurt.play();
                    enemiesOnScreen.remove(i);
                    allyProjectilesOnScreen.remove(j);
                    player.setScore(10);
                    break;
                }
            }
        }
    }
}
