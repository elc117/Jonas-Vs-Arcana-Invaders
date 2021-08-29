package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.List;

public class ObstacleController {
    static long lastObstacle = System.currentTimeMillis();
    static final long obstacleCoolDown = 2000;

    private static Sound obstacleSound = Gdx.audio.newSound(Gdx.files.internal("Sounds/obstacle.wav"));
    private static Sound powerUpSound = Gdx.audio.newSound(Gdx.files.internal("Sounds/powerUp.wav"));

    public static void spawn(List<Obstacle> obstaclesOnScreen, JonasVsArcanaInvaders game, int level){
        long time = System.currentTimeMillis();
        if (obstaclesOnScreen.size() < 3 && time > lastObstacle + obstacleCoolDown){
            int obstacleType = (int) ((Math.random() * 10) % 3);
            int obstacleX = (int) ((Math.random() * 384) + 128);
            if (obstacleType == 0){
                Obstacle obstacle;
                switch (level) {
                    case 2:
                        obstacle = new ComputerTable();
                        break;
                    case 3:
                        obstacle = new FoodTable();
                        break;
                    case 4:
                        obstacle = new Bookshelf();
                        break;
                    default:
                        obstacle = new Car();
                        break;
                }
                obstacle.setPosition(obstacleX, game.getHeight() + 128);
                obstacle.setAnimation();
                obstaclesOnScreen.add(obstacle);
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
            Obstacle obstacle = obstacleOnScreen.get(i);
            obstacle.render(game);
            if(player.allyHitbox.overlaps(obstacle.hitbox)){
                // If para solucionar bug do coracao fechar o game, podemos mudar de local dps
                if(player.getHearts() - obstacle.damage <= 5) {
                    if(obstacle.damage > 0){
                        obstacleSound.play();
                    } else {
                        powerUpSound.play();
                    }
                    player.setHearts(-1 * obstacle.damage);
                }
                player.setBuff(obstacle.buff);
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
