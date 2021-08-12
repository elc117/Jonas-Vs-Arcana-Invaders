package com.uga.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;

	List<Bullet> bulletsOnScreen = new ArrayList<>();
	long lastShot = 0;
	long bulletCoolDown = 300;

	Player player = new Player();
	Scenario scenario = new Scenario();
	Scenario scenario2 = new Scenario();
	Octominion enemy = new Octominion();
	Octominion enemy2 = new Octominion();
	Chloroghost enemy3 = new Chloroghost();
	UI ui = new UI();


	
	@Override
	public void create () {
		batch = new SpriteBatch();

		player.setPosition(512, 200);
		player.setAnimation();

		enemy.setPosition(512, 1660);
		enemy.setAnimation();

		enemy2.setPosition(400, 1370);
		enemy2.setAnimation();

		enemy3.setPosition(200, 1500);
		enemy3.setAnimation();

		scenario.setScenario();
		scenario2.setScenario();
		scenario.setLimit(1152);
		scenario2.setLimit(0);

		ui.setBackground();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		ui.render(batch);
		scenario.render(batch);
		scenario2.render(batch);


		if(scenario.getLimit() == 0){
			scenario2.setLimit(1152);
		} else if (scenario2.getLimit() == -2){
			scenario.setLimit(1150);
		}

		enemy.render(batch);
		enemy2.render(batch);
		enemy3.render(batch);



		long time = System.currentTimeMillis();
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && time > lastShot + bulletCoolDown){
			Bullet bullet = new Bullet();
			bullet.setPosition(player.getx(), player.gety());
			bullet.setAnimation();
			bulletsOnScreen.add(bullet);
			lastShot = time;
		}


		for (Bullet bullet : bulletsOnScreen){
			bullet.render(batch);
		}

		player.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
