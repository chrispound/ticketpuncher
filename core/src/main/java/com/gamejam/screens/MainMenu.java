package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Matrix4;
import com.gamejam.game.GameJam;

/**
 * Created with IntelliJ IDEA.
 * User: Atlas
 * Date: 12/10/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainMenu extends ArcadeScreen implements InputProcessor {
    /** is done flag **/
    private boolean isDone = false;
    /** view & transform matrix **/
    private final Matrix4 viewMatrix = new Matrix4();
    private final Matrix4 transformMatrix = new Matrix4();

    public MainMenu (GameJam game) {
        super(game);
    }

    @Override
    public boolean isDone () {
        return isDone;
    }

    @Override
    public void update (float delta) {
        if (Gdx.input.justTouched()) {
            isDone = true;
        }
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void draw (float delta) {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);


    }

    @Override
    public void dispose () {

    }

    @Override
    protected String getName() {
        return MainMenu.class.getName();
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.ENTER) game.setScreen(new GameScreen(game));
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
