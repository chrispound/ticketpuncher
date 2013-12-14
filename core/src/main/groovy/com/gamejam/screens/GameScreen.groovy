package com.gamejam.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.gamejam.controllers.BobController
import com.gamejam.game.GameJam

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 13-Dec-2013
 * at 8:47 PM
 */
class GameScreen implements Screen, InputProcessor {

    final GameJam game
    private SpriteBatch batch;
    private BobController controller;

    GameScreen(GameJam game) {
        this.batch = new SpriteBatch();
        this.game = game
    }

    @Override
    void render(float delta) {
        batch.begin();
        drawBob();
        batch.end();
    }

    @Override
    void resize(int width, int height) {

    }

    @Override
    void show() {
        controller = new BobController();
        Gdx.input.setInputProcessor(this);
        println("I'm showing!")
    }

    @Override
    void hide() {

    }

    @Override
    void pause() {

    }

    @Override
    void resume() {

    }

    @Override
    void dispose() {

    }

    private void drawBob() {
        Texture bobImgLocation = new Texture("bob.png");
        TextureRegion bobsArea = new TextureRegion(bobImgLocation, 128, 128);
        batch.draw(bobsArea, 128, 128, 128, 128);

    }

    @Override
    boolean keyDown(int keycode) {
       println("USER PRESSED: " + keycode);
        if (keycode == Input.Keys.LEFT) {
            controller.movingLeft();
            println("user moving left");
        } else if (keycode == Input.Keys.RIGHT) {
            controller.movingRight();
            println("user moving right");
        }

        return true;
    }

    @Override
    boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            controller.stopMovingLeft()
        } else if (keycode == Input.Keys.RIGHT) {
            controller.stopMovingRight();
        }

        return true;
    }

    /*
    UNUSED CONTROLS IGNORE
    */

    @Override
    boolean keyTyped(char character) {
        return false
    }

    @Override
    boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false
    }

    @Override
    boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false
    }

    @Override
    boolean touchDragged(int screenX, int screenY, int pointer) {
        return false
    }

    @Override
    boolean mouseMoved(int screenX, int screenY) {
        return false
    }

    @Override
    boolean scrolled(int amount) {
        return false
    }
    /*
    END OF UNSED CONTROLS
     */
}
