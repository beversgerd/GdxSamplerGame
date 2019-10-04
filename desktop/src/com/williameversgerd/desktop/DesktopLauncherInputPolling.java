package com.williameversgerd.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.williameversgerd.GdxSampleGame;
import com.williameversgerd.InputPollingSample;

public class DesktopLauncherInputPolling {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new InputPollingSample(), config);
	}
}
