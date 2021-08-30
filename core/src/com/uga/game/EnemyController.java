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
            int enemyType = (int) ((Math.random() * 10) % 3); //generates a random enemy
            int enemyX = (int) ((Math.random() * 384) + 128);
            if(game.getPlayer().getScore() >= 200 * Math.pow(game.getLevel(),2) && game.getLevel() == 4 && game.getBossStatus() == 0){
                //spawns boss if in last level
                Boss boss = new Boss();
                boss.setPosition(enemyX, game.getHeight() + 128);
                boss.setAnimation();
                enemiesOnScreen.add(boss);
                game.setBossStatus(1);
            }else if (enemyType == 0){
                //generates octominion
                Octominion octominion = new Octominion();
                octominion.setPosition(enemyX, game.getHeight() + 128);
                octominion.setAnimation();
                enemiesOnScreen.add(octominion);
            } else if (enemyType == 1){
                //generates chloroghost
                Chloroghost chloroghost = new Chloroghost();
                chloroghost.setPosition(enemyX, game.getHeight() + 64);
                chloroghost.setAnimation();
                enemiesOnScreen.add(chloroghost);
            }
            lastEnemy = time; //resets time of last enemy
        }
    }

    public static void checkOverlaps(List<Entity> enemiesOnScreen, JonasVsArcanaInvaders game, Player player, List<AllyProjectile> allyProjectilesOnScreen, List<EnemyProjectile> enemyProjectilesOnScreen){
        for (int i = 0; i < enemiesOnScreen.size(); i++){
            Entity entity = enemiesOnScreen.get(i);
            entity.render(game);
            entity.verifyShot(enemyProjectilesOnScreen);
            if(player.allyHitbox.overlaps(entity.enemyHitbox)){
                playerHurt.play(0.3f);
                if (!(entity instanceof Boss)){enemiesOnScreen.remove(i);}
                player.setHearts(-1);
                //if player overlaps enemy and not boss remove (check for every enemy)
                continue;
            }
            if(entity.getPosition().y <= -64){
                enemiesOnScreen.remove(i);
                //enemy get out of screen
                continue;
            }
            for (int j = 0; j < allyProjectilesOnScreen.size(); j++){ //check overlaps for every enemy and every projectile
                if(entity.enemyHitbox.overlaps(allyProjectilesOnScreen.get(j).hitbox)) {
                    enemyHurt.play(0.3f);
                    if (entity instanceof Boss){ //controls boss hp and remove if 0
                        ((Boss) entity).changeHealthPoints();
                        if(((Boss) entity).getHealthPoints() <= 0){
                            enemiesOnScreen.remove(i);
                            player.setScore(100);
                            game.setBossStatus(2);
                        }
                    } else {
                        player.setScore(10); //set score for eliminating enemy
                        enemiesOnScreen.remove(i);
                    }
                    allyProjectilesOnScreen.remove(j);
                    break;
                }
            }
        }
    }
}
