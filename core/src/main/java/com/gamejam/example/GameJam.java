
package com.gamejam.example;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamejam.screens.SplashScreen;


/**
 * Main Game Runner
 *
 */
public class GameJam extends Game implements ApplicationListener {
    SpriteBatch batch;
    public static final String TAG = GameJam.class.getSimpleName();
    /**
     * logger for each game frame.
     */
    private FPSLogger fpsLogger;

    public SplashScreen getSplashScreen(){
         return new SplashScreen(this);
    }

    @Override
    public void create() {
        fpsLogger = new FPSLogger();
        Gdx.app.log(TAG, "Creating Game");
        batch = new SpriteBatch();
        setScreen(getSplashScreen());
        //img = new Texture("C:\\Users\\Atlas\\Pictures\\playstore.png");
//		try {
//			new FreeTypeFontGenerator(Gdx.files.internal("test.fnt"));
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		Bullet.init();
    }

    @Override
    public void resize(int width, int height) {
        //we should keep this fixed
    }

    @Override
    public void pause() {
        //what happens when we pause
    }

    @Override
    public void resume() {


    }

    @Override
    public void dispose() {

    }
}
