package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gamejam.game.GameJam;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

/**
 * Created by Atlas on 12/11/13.
 */
public class SplashScreen extends ArcadeScreen {
    private Image splashImageActor;
    private TextureRegion splashTextureRegion;

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

        // we set the linear texture filter to improve the stretching
       // splashImageActor.setFillParent(true);
        splashImageActor.addAction(sequence(fadeIn(0.75f), delay(1.75f), fadeOut(0.75f),
                new Action() {
                    @Override
                    public boolean act(
                            float delta) {
                        // the last action will move to the next screen
                        game.setScreen(new MainMenu(game));
                        return true;
                    }
                }));

        // in the image atlas, our splash image begins at (0,0) at the
        // upper-left corner and has a dimension of 512x301
       stage.addActor(splashImageActor);

    }

}
