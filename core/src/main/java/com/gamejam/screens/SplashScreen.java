package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gamejam.game.GameJam;

/**
 * Created by Atlas on 12/11/13.
 */
public class SplashScreen extends ArcadeScreen {
    private Texture splashTexture;
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
        splashTexture = new Texture("GameJamSplashScreen.png");

        // we set the linear texture filter to improve the stretching
        splashTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        // in the image atlas, our splash image begins at (0,0) at the
        // upper-left corner and has a dimension of 512x301
        splashTextureRegion = new TextureRegion(splashTexture, 0, 0, 1024, 512);
    }

    @Override
    public void render(float delta){
        super.render(delta);

        // we use the SpriteBatch to draw 2D textures (it is defined in our base
        // class: AbstractScreen)
        Batch batch = new SpriteBatch();
        batch.begin();

        // we tell the batch to draw the region starting at (0,0) of the
        // lower-left corner with the size of the screen
        batch.draw( splashTextureRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );

        // the end method does the drawing
        batch.end();
    }
}
