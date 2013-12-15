package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.gamejam.game.GameJam;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/**
 * Created by Atlas on 12/11/13.
 */
public class SplashScreen extends ArcadeScreen {
    private Image splashImageActor;
    private TextureRegion splashTextureRegion;
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

    public SplashScreen(GameJam game) {
        super(game);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(float delta) {

    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    protected String getName() {
        return SplashScreen.class.getName();
    }

    @Override
    public void show() {
        super.show();

        // load the splash image and create the texture region
        splashImageActor = new Image(new Texture("gjlogoTitle.png"));

        music = Gdx.audio.newMusic(Gdx.files.internal("DrP_Tetris.mp3"));
        music.setLooping(true);
        music.play();

        // we set the linear texture filter to improve the stretching
        splashImageActor.setFillParent(true);
        splashImageActor.addAction(sequence(fadeIn(0.75f), delay(1.75f), fadeOut(0.75f),
                new Action() {
                    @Override
                    public boolean act(
                            float delta) {
                        // the last action will move to the next screen
                        game.setScreen(new MainMenu(game, music));
                        return true;
                    }
                }));

        // in the image atlas, our splash image begins at (0,0) at the
        // upper-left corner and has a dimension of 512x301
       stage.addActor(splashImageActor);

    }

}
