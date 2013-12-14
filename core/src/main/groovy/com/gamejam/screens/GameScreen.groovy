package com.gamejam.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL10
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Vector2
import com.gamejam.actors.Bob
import com.gamejam.actors.BobsFriend
import com.gamejam.controllers.BobController
import com.gamejam.controllers.BobsFriendController
import com.gamejam.game.GameJam
import com.gamejam.model.LinePosHelper
import com.gamejam.views.Terminal
import com.gamejam.model.PositionHelper

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
    SpriteBatch batch
    BobController controller
    BobsFriendController bobsFriendController
    int width
    int height
    SpriteBatch spriteBatch = new SpriteBatch()
    Texture lineTexture = new Texture(Gdx.files.internal("templine.png"))
    Texture deskTexture = new Texture(Gdx.files.internal("desk.png"))
    Bob bobTheAlmighty
    BobsFriend bobsFriend
    Terminal terminal


    GameScreen(GameJam game) {
        terminal = new Terminal()
        this.batch = new SpriteBatch()
        this.game = game

        controller = new BobController(terminal)
        bobTheAlmighty = terminal.bobTheAlmightyPuncherOfAllThings

        bobsFriendController = new BobsFriendController(terminal)
        bobsFriend = terminal.bobsFriend

    }

    @Override
    void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1)
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)
        spriteBatch.begin()
        spriteBatch.draw(deskTexture, PositionHelper.gameStageStartX.toFloat(), (PositionHelper.gameStageStartY - PositionHelper.deskHeight).toFloat())
        drawBob()

        LinePosHelper.each { line ->
            (0..9).each { linePos ->
                spriteBatch.draw(lineTexture, line.getLinePosition(linePos).x, line.getLinePosition(linePos).y)
                drawBobsFriend(line.getLinePosition(linePos))
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
        Gdx.input.setInputProcessor(this)
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
        Vector2 bobsPosition = new Vector2()
        int posY = 200
        Texture bobImgLocation = new Texture("bob.png")
        TextureRegion bobsArea = new TextureRegion(bobImgLocation, 128, 128)
        switch (bobTheAlmighty.getCurrentLine()) {
            case 1:
                bobsPosition.set(112, 640)
                break
            case 2:
                bobsPosition.set(296, 640)
                break
            case 3:
                bobsPosition.set(480, 640)
                break
            case 4:
                bobsPosition.set(664, 640)
                break
            case 5:
                bobsPosition.set(848, 640)
                break
        }
        spriteBatch.draw(bobsArea, bobsPosition.x, bobsPosition.y, 128, 128)
    }

    private void drawBobsFriend(Vector2 position) {
        Vector2 bobsFriendPosition = new Vector2()
        int posY = 0
        Texture bobFriendImgLocation = new Texture("BobFriendStill.png")
        TextureRegion bobsArea = new TextureRegion(bobFriendImgLocation, 64, 64)
        switch (bobsFriend.getCurrentRow()) {
            case 0:
                bobsFriendPosition.set(112, 0)
                break
            case 1:
                bobsFriendPosition.set(112, 1)

        }
        spriteBatch.draw(bobsArea, position.x, position.y)
    }

    @Override
    boolean keyDown(int keycode) {
        println("USER PRESSED: " + keycode)
        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.RIGHT) {

            if (keycode == Input.Keys.LEFT) {
                controller.movingLeft()
                println("user moving left")
            } else if (keycode == Input.Keys.RIGHT) {
                controller.movingRight()
                println("user moving right")
            }
            controller.processInputMapDeterminePosition()
        } else {
            println("Bob Is Punching a Ticket")
            controller.bobIsPunchingATicket(keycode)
            controller.checkIfComboIsCorrect()
        }

        return true;
    }


    @Override
    boolean keyUp(int keycode) {
        controller.setBobAbleToMove(true)
        controller.setMapUpdatable(true)
        if (keycode == Input.Keys.LEFT) {
            controller.stopMovingLeft()
        } else if (keycode == Input.Keys.RIGHT) {
            controller.stopMovingRight()
        }

        return true
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
