package com.gamejam.screens;

import com.gamejam.game.GameJam;

/**
 * Created by Chris on 12/13/13.
 */
public class GameScreen extends ArcadeScreen{
    protected GameScreen(GameJam game) {
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
        return null;
    }
}
