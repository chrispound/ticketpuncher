package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.gamejam.game.GameJam;

/**
 * Created with IntelliJ IDEA.
 * User: e590436
 * Date: 12/15/13
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class HowToPlayScreen extends ArcadeScreen implements InputProcessor {

    Image howToPlay;
    private boolean isDone = false;

    public HowToPlayScreen(GameJam game) {
        super(game);
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.justTouched()) {
            isDone = true;
        }
    }

    @Override
    public Skin getSkin() {
        return super.getSkin();
    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
        howToPlay = new Image(new Texture("howToPlay.jpg"));
        howToPlay.setPosition(0, 0);
        stage.addActor(howToPlay);
    }

    @Override
    protected String getName() {
        return HowToPlayScreen.class.getName();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            default:
                game.setScreen((new MainMenu(game)));
        }
        return true;
    }
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
