package com.mygdx.endlessrunning.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.endlessrunning.EndlessrunningGame;
import com.mygdx.endlessrunning.utility.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
        config.height = 480;
        config.resizable = false;
		config.forceExit = true;
		new LwjglApplication(new EndlessrunningGame(), config);
	}
}
