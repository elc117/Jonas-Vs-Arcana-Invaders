package com.uga.game;


import com.badlogic.gdx.Gdx;

import java.util.List;

public class EnemyController {
    static long lastEnemy = System.currentTimeMillis();
    static long enemyCoolDown = 2000;

    public static void spawn(List<Entity> enemiesOnScreen, JonasVsArcanaInvaders game, Player player, List<AllyProjectile> allyProjectilesOnScreen, List<EnemyProjectile> enemyProjectilesOnScreen){ //arrumar esse crime depois
        long time = System.currentTimeMillis();
        if (enemiesOnScreen.size() < 5 && time > lastEnemy + enemyCoolDown){
            int enemyType = (int) ((Math.random() * 10) % 2);
            int enemyX = (int) ((Math.random() * 384) + 128);
            if (enemyType == 0){
                Octominion octominion = new Octominion();
                octominion.setPosition(enemyX, game.getHeight() + 128);
                octominion.setAnimation();
                enemiesOnScreen.add(octominion);
            } else {
                Chloroghost chloroghost = new Chloroghost();
                chloroghost.setPosition(enemyX, game.getHeight() + 64);
                chloroghost.setAnimation();
                enemiesOnScreen.add(chloroghost);
            }
        }

        for (int i = 0; i < enemiesOnScreen.size(); i++){
            enemiesOnScreen.get(i).render(game.batch);
            enemiesOnScreen.get(i).verifyShot(enemyProjectilesOnScreen);
            if(player.allyHitbox.overlaps(enemiesOnScreen.get(i).enemyHitbox)){
                Gdx.app.log("#INFO", "Inimigo matou Player");
                game.setScreen(new TitleScreen(game));
            }
            for (int j = 0; j < allyProjectilesOnScreen.size(); j++){
                if(enemiesOnScreen.get(i).enemyHitbox.overlaps(allyProjectilesOnScreen.get(j).allyHitbox)) {
                    enemiesOnScreen.remove(i);
                    allyProjectilesOnScreen.remove(j);
                    player.setScore(10);
                    break;
                } else if(enemiesOnScreen.get(i).getPosition().y <= -64){
                    enemiesOnScreen.remove(i);
                }
            }
        }
    }
}
