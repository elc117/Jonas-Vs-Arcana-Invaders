package com.uga.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.List;

public class EnemyController {
    private static long lastEnemy = System.currentTimeMillis();
    private static final long enemyCoolDown = 300;

    private static Sound playerHurt = Gdx.audio.newSound(Gdx.files.internal("Sounds/playerHurt.wav"));
    private static Sound enemyHurt = Gdx.audio.newSound(Gdx.files.internal("Sounds/enemyHurt.wav"));

    public static void spawn(List<Entity> enemiesOnScreen, JonasVsArcanaInvaders game){
        long time = System.currentTimeMillis();
        if (enemiesOnScreen.size() < 5 + game.getLevel() && time > lastEnemy + enemyCoolDown){
            int enemyType = (int) ((Math.random() * 10) % 3);
            int enemyX = (int) ((Math.random() * 384) + 128);
            if(game.getPlayer().getScore() >= 200 * Math.pow(game.getLevel(),2) && game.getLevel() == 4 && game.getBossStatus() == 0){
                Boss boss = new Boss();
                boss.setPosition(enemyX, game.getHeight() + 128);
                boss.setAnimation();
                enemiesOnScreen.add(boss);
                game.setBossStatus(1);
            }else if (enemyType == 0){
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
            Entity entity = enemiesOnScreen.get(i);
            entity.render(game);
            entity.verifyShot(enemyProjectilesOnScreen);
            if(player.allyHitbox.overlaps(entity.enemyHitbox)){
                playerHurt.play();
                if (!(entity instanceof Boss)){enemiesOnScreen.remove(i);}
                player.setHearts(-1);
                continue;
            }
            if(entity.getPosition().y <= -64){
                enemiesOnScreen.remove(i);
                continue;
            }
            for (int j = 0; j < allyProjectilesOnScreen.size(); j++){
                if(entity.enemyHitbox.overlaps(allyProjectilesOnScreen.get(j).hitbox)) {
                    enemyHurt.play();
                    if (entity instanceof Boss){
                        ((Boss) entity).changeHealthPoints();
                        if(((Boss) entity).getHealthPoints() <= 0){
                            enemiesOnScreen.remove(i);
                            player.setScore(100);
                            game.setBossStatus(2);
                        }
                    } else {
                        player.setScore(100);
                        enemiesOnScreen.remove(i);
                    }
                    allyProjectilesOnScreen.remove(j);
                    break;
                }
            }
        }
    }
}
