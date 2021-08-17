package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class AllyProjectile extends Projectile {
    float elapsedTime;

    public AllyProjectile(){
        super.allyHitbox = new Rectangle();
        super.spritesheet = "Projectile-Spritesheet.png";
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        allyHitbox.set(position.x, position.y, hitbox, hitbox);

        batch.draw((TextureRegion) super.animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.position.y += 6;
    }
}
