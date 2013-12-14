
package com.gamejam.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamejam.screens.SplashScreen;


/**
 * Main Game Runner
 */
public class GameJam extends Game implements ApplicationListener {
    SpriteBatch batch;
    public static final String TAG = GameJam.class.getSimpleName();
    /**
     * logger for each game frame.
     */
    private FPSLogger fpsLogger;

    public SplashScreen getSplashScreen() {
        return new SplashScreen(this);
    }

    @Override
    public void create() {
        Texture.setEnforcePotImages(false);
        fpsLogger = new FPSLogger();
        Gdx.app.log(TAG, "Creating Game");
        batch = new SpriteBatch();
        setScreen(getSplashScreen());
    }

    @Override
    public void render() {
        super.render();
        //fpsLogger.log();
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
