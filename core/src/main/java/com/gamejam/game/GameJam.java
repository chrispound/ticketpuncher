
package com.gamejam.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamejam.screens.SplashScreen;

import java.util.HashMap;


/**
 * Main Game Runner
 */
public class GameJam extends Game implements ApplicationListener {
    SpriteBatch batch;
    Music music = new Music() {
        @Override
        public void play() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void pause() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void stop() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public boolean isPlaying() {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setLooping(boolean isLooping) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public boolean isLooping() {
            return false;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setVolume(float volume) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public float getVolume() {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setPan(float pan, float volume) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public float getPosition() {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void dispose() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void setOnCompletionListener(OnCompletionListener listener) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    };
    public static final String TAG = GameJam.class.getSimpleName();
    /**
     * logger for each game frame.
     */
    private FPSLogger fpsLogger;
    private HashMap<Integer, Long> highScore;

    public SplashScreen getSplashScreen() {
        return new SplashScreen(this);
    }

    public void setMusic(Music music) {
        this.music = music;
    }
    public void playMusic() {
        this.music.play();
    }
    public void stopMusic() {
        this.music.stop();
    }
    public void loopMusic() {
        this.music.setLooping(true);
    }
    @Override
    public void create() {
        Texture.setEnforcePotImages(false);
        //get high scores!.
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
