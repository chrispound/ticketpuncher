package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.gamejam.game.GameJam;

/**
 * Created by Chris Pound on 12/15/13.
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
        Image highScoreBg = new Image(new Texture("highscore.png"));
        highScoreBg.setPosition(0, 0);
        stage.addActor(highScoreBg);
        int tempY = 555;
        int tempX = 240;
        for (int i = 0; i < game.getProfileManager().retrieveProfile().getHighScores().size(); i++) {
            Label highScores = new Label("" + game.getProfileManager().retrieveProfile().getHighScores().get(i), getSkin());
            highScores.setFontScale(2.3f);
            highScores.setColor(Color.CYAN);
            if (i == 9) {
                highScores.setPosition(tempX + 15, tempY);
            } else {
                highScores.setPosition(tempX, tempY);
            }
            tempY = tempY - 58;
            stage.addActor(highScores);
        }

//        Label instructions = new Label("Press enter to return to main menu", getSkin());
//        instructions.setFontScale(2.5f);
//        tempY = tempY - 50;
//        instructions.setPosition(280, tempY);
//        stage.addActor(instructions);

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
