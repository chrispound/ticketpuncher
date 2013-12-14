package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.gamejam.game.GameJam;

/**
 * Created with IntelliJ IDEA.
 * User: Atlas
 * Date: 12/10/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ArcadeScreen implements Screen {
    // the fixed viewport dimensions (ratio: 1.6)
    public static final int GAME_VIEWPORT_WIDTH = 400, GAME_VIEWPORT_HEIGHT = 240;
    public static final int MENU_VIEWPORT_WIDTH = 800, MENU_VIEWPORT_HEIGHT = 480;

    protected GameJam game;

    private BitmapFont font;
    private SpriteBatch batch;
    private Skin skin;
    private TextureAtlas atlas;
    private Table table;
    protected final Stage stage;

    protected ArcadeScreen(GameJam game) {
        this.game = game;
        this.stage = new Stage( 400, 800, true );
    }

    /**
     * Called when the screen should update itself, e.g. continue a simulation etc.
     */
    public abstract void update(float delta);

    /**
     * Called when a screen should render itself
     */
    public abstract void draw(float delta);

    /**
     * Called by GdxInvaders to check whether the screen is done.
     *
     * @return true when the screen is done, false otherwise
     */
    public abstract boolean isDone();

    @Override
    public void render(float delta) {
        // (1) process the game logic

        // update the actors
        stage.act( delta );

        // (2) draw the result

        // clear the screen with the given RGB color (black)
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        // draw the actors
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        hide();
    }

    @Override
    public void show() {
        Gdx.app.log(GameJam.TAG, "Showing screen: " + getName());
        //stage is our input processor
        Gdx.input.setInputProcessor( stage );
    }

    protected abstract String getName();

}
