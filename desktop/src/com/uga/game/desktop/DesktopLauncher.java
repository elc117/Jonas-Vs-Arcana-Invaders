package com.uga.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.uga.game.JonasVsArcanaInvaders;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new JonasVsArcanaInvaders(), config);
		config.title = "Jonas vs Arcana Invaders";
		config.width = 640;
		config.height = 1152;
	}
}
