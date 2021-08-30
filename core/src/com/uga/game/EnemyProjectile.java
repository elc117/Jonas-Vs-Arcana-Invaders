package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class EnemyProjectile extends Projectile {

    public EnemyProjectile(){
        super.hitbox = new Rectangle();
        super.spritesheet = "EnemyProjectile-Spritesheet.png";
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        hitbox.set(position.x + super.hitboxSize, position.y + super.hitboxSize, super.hitboxSize, super.hitboxSize);

        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.position.x += (Math.random() - 0.5)*5; //projectile movement effect
        super.position.y -= 6;
    }
}
