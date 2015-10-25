package com.zachdayz.roguehate.desktop;

import com.zachdayz.roguehate.frontend.RoguehateGraphicalSession;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new RoguehateGraphicalSession(), config);
	}
}
