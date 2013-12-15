package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.gamejam.game.GameJam;


/**
 * Created by
 * Matthew Fitzpatrick
 * on 14-Dec-2013
 * at 8:10 PM
 */
public class GameOverScreen extends ArcadeScreen implements InputProcessor {
    protected GameOverScreen(GameJam game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        //do cool magic scene2d here

        //display final Score
        Label gameOverMessage = new Label("Game Over! \n Press Enter to Restart", getSkin());
        gameOverMessage.setPosition(250, 500);
        gameOverMessage.setFontScale(2f);
        stage.addActor(gameOverMessage);

        Label returnToMenu = new Label(" Press Any Other Key to go to Main Menu ", getSkin());
        returnToMenu.setPosition(170, 450);
        returnToMenu.setFontScale(2f);
        stage.addActor(returnToMenu);
        Gdx.input.setInputProcessor(this);
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
        return GameOverScreen.class.getName();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ENTER:
            case Input.Keys.SPACE:
                game.setScreen(new GameScreen(game));
                break;
            default:
                game.setScreen(new MainMenu(game));
                break;
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
