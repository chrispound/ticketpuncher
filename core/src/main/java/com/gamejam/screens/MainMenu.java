package com.gamejam.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.gamejam.game.GameJam;

/**
 * Created with IntelliJ IDEA.
 * User: Atlas
 * Date: 12/10/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainMenu extends ArcadeScreen implements InputProcessor {
    /**
     * is done flag *
     */
    private boolean isDone = false;
    /**
     * com.gamejam.view & transform matrix *
     */
    private final Matrix4 viewMatrix = new Matrix4();
    private final Matrix4 transformMatrix = new Matrix4();

    public static final float BUTTON_WIDTH = 300f;
    public static final float BUTTON_HEIGHT = 60f;
    public static final float BUTTON_SPACING = 10f;
    public Image gameLogo;

    public MainMenu(GameJam game) {
        super(game);
    }
    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.justTouched()) {
            isDone = true;
        }
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this);

        // label "welcome"
        /*Label title = new Label("Ticket Puncher", getSkin());
        title.setPosition(325, 500);
        title.setFontScale(3);
        title.setColor(Color.WHITE);
        stage.addActor(title);*/

        gameLogo = new Image(new Texture("gameLogo.png"));
        gameLogo.setPosition(250, 200);
        stage.addActor(gameLogo);

        Label pressToContinue = new Label("Press Player 1 Start To Continue", getSkin());
        pressToContinue.setFontScale(1.5f);
        pressToContinue.setPosition(325, 200);
        pressToContinue.setColor(Color.CYAN);
        stage.addActor(pressToContinue);

        Label howTo = new Label("Press 2 for game instructions", getSkin());
        howTo.setFontScale(1.5f);
        howTo.setPosition(325, 100);
        howTo.setColor(Color.CYAN);
        stage.addActor(howTo);

        Label goToHighScore = new Label("Press Player H to see high scores", getSkin());
        goToHighScore.setFontScale(1.5f);
        goToHighScore.setPosition(325, 150);
        goToHighScore.setColor(Color.CYAN);
        stage.addActor(goToHighScore);

    }

    @Override
    public void draw(float delta) {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);


    }

    @Override
    public void dispose() {

    }

    @Override
    protected String getName() {
        return MainMenu.class.getName();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ENTER || keycode == Input.Keys.NUM_1) {
            game.setScreen(new GameScreen(game));
            this.hide();
        } else if (keycode == Input.Keys.H) {
            game.setScreen(new HighScores(game));
            this.hide();
        } else if(keycode == Input.Keys.NUM_2) {
            game.setScreen(new HowToPlayScreen(game));
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
