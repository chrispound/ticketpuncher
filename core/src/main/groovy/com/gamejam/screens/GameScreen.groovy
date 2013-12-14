package com.gamejam.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL10
import com.gamejam.controller.TerminalController
import com.gamejam.game.GameJam
import com.gamejam.model.Terminal
import com.gamejam.view.TerminalRenderer


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
    TerminalController terminalController
    TerminalRenderer terminalRenderer
    Terminal terminal
    def movementLocked = false

    GameScreen(GameJam game) {
        this.game = game
        terminal = new Terminal()
        terminalController = new TerminalController(terminal)
        terminalRenderer = new TerminalRenderer(terminal)
    }

//    @Override
//    void render(float delta) {
//        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1)
//        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)
//        camera.update()
//        spriteBatch.setProjectionMatrix(camera.combined)
//        spriteBatch.begin()
//        spriteBatch.draw(deskTexture, gameStageStartX.toFloat(), (gameStageStartY - deskHeight).toFloat())
//        drawBob()
//
//        LinePosHelper.each { line ->
//            (0..9).each { linePos ->
//                spriteBatch.draw(lineTexture, line.getLinePosition(linePos).x, line.getLinePosition(linePos).y)
//                drawBobsFriend(line.getLinePosition(linePos))
//            }
//        }
//        comboAnimatorController.drawCombo(batch)
//        spriteBatch.end()
//    }


    @Override
    void show() {
        Gdx.input.setInputProcessor(this)
    }


    @Override
    void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1)
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

        /**
         * TerminalController.update will be responsbile for the following
         * - Add A Person to the Lines
         * - Update Bob's Position
         * - Update Line's Positions
         * - ???x
         */
        terminalController.update()
        /**
         * TerminalRenderer.render will be responsible for the following
         * - Draw Bob
         * - Draw BobFriends
         * - Draw Score Points after a ticket punch?
         * - Draw Combo's?
         * -
         */
        terminalRenderer.render()

//        spriteBatch.begin()
//        spriteBatch.draw(deskTexture, gameStageStartX.toFloat(), (gameStageStartY - deskHeight).toFloat())
//        drawBob()
//
//        LinePosHelper.each { line ->
//            (0..9).each { linePos ->
//                spriteBatch.draw(lineTexture, line.getLinePosition(linePos).x, line.getLinePosition(linePos).y)
//                drawBobsFriend(line.getLinePosition(linePos))
//            }
//        }
//        spriteBatch.end()
    }

//    private void drawBobsFriend(Vector2 position) {
//        Vector2 bobsFriendPosition = new Vector2()
//        int posY = 0
//        TextureRegion bobsArea = new TextureRegion(bobFriendImgLocation, 64, 64)
//        switch (bobsFriend.getCurrentRow()) {
//            case 0:
//                bobsFriendPosition.set(112, 0)
//                break
//            case 1:
//                bobsFriendPosition.set(112, 1)
//
//        }
//        spriteBatch.draw(bobsArea, position.x, position.y)
//    }

    @Override
    boolean keyDown(int keycode) {
        println("Unlocked Movement")
        println("USER PRESSED: " + keycode)
        switch (keycode) {
            case Input.Keys.LEFT:
                terminalController.moveBobLeft()
                break;
            case Input.Keys.RIGHT:
                terminalController.moveBobRight()
                break;
            default:
                terminalController.bobIsPunchingATicket(keycode)
                terminalController.checkIfComboIsCorrect()
                break;
        }
        return true;
    }

    @Override
    boolean keyUp(int keycode) {
        terminalController.stopMovingBob()
        return true
    }


    @Override
    void resize(int width, int height) {
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
    END OF UNUSED CONTROLS
     */
}
