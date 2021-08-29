package com.uga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AllyProjectile extends Projectile {
    float elapsedTime;
    private Sound sound;

    public AllyProjectile(){
        super.spritesheet = "Projectile-Spritesheet.png";
        sound = Gdx.audio.newSound(Gdx.files.internal("Sounds/projectile.wav"));
        sound.play();
    }

    @Override
    public void render(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();

        hitbox.set(position.x, position.y, hitboxSize, hitboxSize);

        batch.draw((TextureRegion) super.animation.getKeyFrame(elapsedTime,true), super.position.x, super.position.y);
        super.position.x += (Math.random() - 0.5)*5;
        super.position.y += 6;
    }
}
