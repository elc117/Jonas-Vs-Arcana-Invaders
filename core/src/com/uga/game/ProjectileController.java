package com.uga.game;

import com.badlogic.gdx.Gdx;

import java.util.List;

public class ProjectileController {
    public static void checkProjectiles(Player player, List<Projectile> projectilesOnScreen){
        player.verifyShot(projectilesOnScreen);
        for (Projectile projectile : projectilesOnScreen){
            //projectile.render(game.batch); //Quebra o jogo!!
            if(player.allyHitbox.overlaps(projectile.enemyHitbox)) Gdx.app.log("#INFO", "My message.");
        }
        //Isso aqui ta errado, chama projectile e nao enemy ou ally projectile. O projectile.render() vai ser
        //abstrato, entao tem que chamar o da classe filha.
    }
}
