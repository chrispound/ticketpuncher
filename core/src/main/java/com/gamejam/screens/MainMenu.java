package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
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
public class MainMenu extends ArcadeScreen {
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
}
