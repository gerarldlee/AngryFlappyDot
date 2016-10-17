package com.gerarldlee.angryflappydot.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gerarldlee.angryflappydot.AngryFlappyDot;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = AngryFlappyDot.SCREEN_HEIGHT;
		config.width = AngryFlappyDot.SCREEN_WIDTH;
		config.title = AngryFlappyDot.TITLE;

		new LwjglApplication(new AngryFlappyDot(), config);
	}
}
