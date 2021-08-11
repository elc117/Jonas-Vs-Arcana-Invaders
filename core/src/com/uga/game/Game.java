package com.uga.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.Rectangle;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Rectangle teste;
	Player player = new Player();
	Scenario scenario = new Scenario();
	Scenario scenario2 = new Scenario();


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player.setCharacter();
		teste = new Rectangle();

		teste.x = 284;
		teste.y = 20;
		teste.width = 64;
		teste.height = 64;
		scenario.setScenario();
		scenario2.setScenario();
		scenario.setLimit(1152);
		scenario2.setLimit(0);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.render(teste, batch);

		scenario.render(batch);
		scenario2.render(batch);
		/*if(scenario.getLimit() == 0){
			scenario.setLimit(1152);
		}else if (scenario2.getLimit() == 1152){
			//arrumar essa logica
		}*/
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
