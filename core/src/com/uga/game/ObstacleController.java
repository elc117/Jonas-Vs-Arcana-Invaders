package com.uga.game;

import com.badlogic.gdx.Gdx;

import java.util.List;

public class ObstacleController {
    static long lastObstacle = System.currentTimeMillis();
    static final long obstacleCoolDown = 1000;

    public static void spawn(List<Obstacle> obstaclesOnScreen, JonasVsArcanaInvaders game){
        long time = System.currentTimeMillis();
        if (obstaclesOnScreen.size() < 5 && time > lastObstacle + obstacleCoolDown){
            int enemyType = (int) ((Math.random() * 10) % 3);
            int enemyX = (int) ((Math.random() * 384) + 128);
            if (enemyType == 0){
                Car car = new Car();
                car.setPosition(enemyX, game.getHeight() + 128);
                car.setAnimation();
                obstaclesOnScreen.add(car);
            } else if (enemyType == 1){
                Heart heart = new Heart();
                heart.setPosition(enemyX, game.getHeight() + 128);
                heart.setAnimation();
                obstaclesOnScreen.add(heart);
            }
            else if (enemyType == 2){
                Buff buff = new Buff();
                buff.setPosition(enemyX, game.getHeight() + 128);
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
                player.setDamage(obstacleOnScreen.get(i).damage);
                player.setBuff(obstacleOnScreen.get(i).buff);
                obstacleOnScreen.remove(i);
                continue;
            }
            if(obstacleOnScreen.get(i).getPosition().y <= -64){
                obstacleOnScreen.remove(i);
                continue;
            }
        }
    }
}
