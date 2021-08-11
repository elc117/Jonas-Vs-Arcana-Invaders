package com.uga.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Rectangle teste;

	TextureRegion[] animationFrames;
	Animation animation;
	float elapsedTime;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Jonas-Sprite-Sheet.png");
		teste = new Rectangle();

		teste.x = 284;
		teste.y = 20;
		teste.width = 64;
		teste.height = 64;

		TextureRegion[][] tmpFrames = TextureRegion.split(img,128,128);

		animationFrames = new TextureRegion[6];
		int index = 0;

		for (int i = 0; i < 6; i++){
				animationFrames[index++] = tmpFrames[0][i];
		}

		animation = new Animation(1f/6f,animationFrames);
	}

	@Override
	public void render () {
		elapsedTime += Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime,true), teste.x, teste.y);
		batch.end();

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && teste.x > 128) teste.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && teste.x < 512) teste.x += 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && teste.y > 0) teste.y -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.UP) && teste.y < 1024) teste.y += 200 * Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
