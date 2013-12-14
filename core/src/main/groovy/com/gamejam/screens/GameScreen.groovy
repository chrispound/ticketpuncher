package com.gamejam.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen

import com.badlogic.gdx.graphics.GL10
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

    //Desk is 800x64
    //Bob is 64x64
    //Customers are 64x64
    //Lines are 704(11)x64

    final GameJam game
    private SpriteBatch batch;
    private BobController controller;
    int width;
    int height;
    SpriteBatch spriteBatch = new SpriteBatch()
    Texture lineTexture = new Texture(Gdx.files.internal("templine.png"))
    Texture deskTexture = new Texture(Gdx.files.internal("desk.png"))

    GameScreen(GameJam game) {
        this.batch = new SpriteBatch();
        this.game = game
    }

    @Override
    void render(float delta) {
        def startLineX = 112
        def separationPixels = 184
        def startingLineY = 672-32
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1)
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)
        spriteBatch.begin()
        spriteBatch.draw(deskTexture, 112, 800-64-32)
        drawBob()
        (0..4).each { lineNumber ->
            def tempLineY = startingLineY
            (1..11).each {
                spriteBatch.draw(lineTexture, startLineX + (lineNumber * separationPixels), tempLineY)
                tempLineY -= 64
            }
        }
        spriteBatch.end()
    }

    @Override
    void resize(int width, int height) {
        this.width = width
        this.height = height
    }

    @Override
    void show() {
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
        spriteBatch.draw(bobsArea, 128, 128, 128, 128);
    }

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
