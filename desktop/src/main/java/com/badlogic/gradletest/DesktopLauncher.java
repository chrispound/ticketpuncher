
package com.badlogic.gradletest;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gamejam.game.GameJam;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                  //title is class name
        //Desk is 800 wide 64 height
        //Bob is 64x64
        //customers/linesMap 64x64
        config.width = 1024;
        config.height = 800;
        config.resizable = false;
        config.addIcon("ic_icon.png", Files.FileType.Internal);
        new LwjglApplication(new GameJam(), config);
	}
}
