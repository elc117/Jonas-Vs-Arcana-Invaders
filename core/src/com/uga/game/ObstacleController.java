package com.uga.game;

import com.badlogic.gdx.Gdx;

import java.util.List;

public class ObstacleController {
    static long lastObstacle = System.currentTimeMillis();
    static final long obstacleCoolDown = 2000;

    public static void spawn(List<Obstacle> obstaclesOnScreen, JonasVsArcanaInvaders game){
        long time = System.currentTimeMillis();
        if (obstaclesOnScreen.size() < 3 && time > lastObstacle + obstacleCoolDown){
            int obstacleType = (int) ((Math.random() * 10) % 3);
            int obstacleX = (int) ((Math.random() * 384) + 128);
            if (obstacleType == 0){
                Car car = new Car();
                car.setPosition(obstacleX, game.getHeight() + 128);
                car.setAnimation();
                obstaclesOnScreen.add(car);
            } else if (obstacleType == 1){
                Heart heart = new Heart();
                heart.setPosition(obstacleX, game.getHeight() + 128);
                heart.setAnimation();
                obstaclesOnScreen.add(heart);
            }
            else if (obstacleType == 2){
                Buff buff = new Buff();
                buff.setPosition(obstacleX, game.getHeight() + 128);
                buff.setAnimation();
                obstaclesOnScreen.add(buff);
            }
            lastObstacle = time;
        }
    }

    public static void checkOverlaps(List<Obstacle> obstacleOnScreen, JonasVsArcanaInvaders game, Player player){
        for (int i = 0; i < obstacleOnScreen.size(); i++){
            obstacleOnScreen.get(i).render(game.batch);
            if(player.allyHitbox.overlaps(obstacleOnScreen.get(i).enemyHitbox)){
                // If para solucionar bug do coracao fechar o game, podemos mudar de local dps
                if(player.getHearts() - obstacleOnScreen.get(i).damage <= 5) {
                    player.setDamage(obstacleOnScreen.get(i).damage);
                }
                player.setBuff(obstacleOnScreen.get(i).buff);
                obstacleOnScreen.remove(i);
                continue;
            }
            if(obstacleOnScreen.get(i).getPosition().y <= -192){
                obstacleOnScreen.remove(i);
                continue;
            }
        }
    }
}
