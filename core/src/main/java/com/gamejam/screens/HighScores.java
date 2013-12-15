package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.gamejam.game.GameJam;

/**
 * Created by Chris on 12/15/13.
 */
public class HighScores extends ArcadeScreen implements InputProcessor {
    protected HighScores(GameJam game) {
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
        return HighScores.class.getSimpleName();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        Label highScoreTitle = new Label("High Scores", getSkin());
        highScoreTitle.setFontScale(2.5f);
        highScoreTitle.setPosition(325, 700);
        stage.addActor(highScoreTitle);
        int tempY = 680;
        for (int i = 0; i < game.getProfileManager().retrieveProfile().getHighScores().size(); i++) {
            Label highScores = new Label(i + 1 + ") " + game.getProfileManager().retrieveProfile().getHighScores().get(i), getSkin());
            highScores.setFontScale(2f);
            tempY = tempY - 50;
            highScores.setPosition(325, tempY);
            stage.addActor(highScores);
        }

        Label instructions = new Label("Press enter to return to main menu", getSkin());
        instructions.setFontScale(2.5f);
        tempY = tempY - 50;
        instructions.setPosition(280, tempY);
        stage.addActor(instructions);

    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER) {
            game.setScreen(new MainMenu(game));
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
