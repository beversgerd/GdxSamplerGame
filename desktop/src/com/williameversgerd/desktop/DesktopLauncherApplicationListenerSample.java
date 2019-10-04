package com.williameversgerd.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.williameversgerd.ApplicationListenerSample;
import com.williameversgerd.GdxSampleGame;

public class DesktopLauncherApplicationListenerSample {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ApplicationListenerSample(), config);
	}
}
