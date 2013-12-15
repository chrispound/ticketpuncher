package com.gamejam.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.GL10
import com.badlogic.gdx.utils.TimeUtils
import com.gamejam.controller.TerminalController
import com.gamejam.game.GameJam
import com.gamejam.model.Passenger
import com.gamejam.model.Terminal
import com.gamejam.view.TerminalRenderer


/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 13-Dec-2013
 * at 8:47 PM
 */
class GameScreen implements Screen, InputProcessor {

    final GameJam game
    TerminalController terminalController
    TerminalRenderer terminalRenderer
    Terminal terminal
    Random random
    //These twotimes are in nanoseconds as its most accurate
    long lastPassengerTime
    long timeBetweenPassengers = 1000000000
    Music music

    GameScreen(GameJam game, Music music) {
        this.game = game
        random = new Random()
        terminal = new Terminal()
        terminalController = new TerminalController(terminal)
        terminalRenderer = new TerminalRenderer(terminal)
        spawnPassenger()
        this.music = music
    }
    @Override
    void show() {
        Gdx.input.setInputProcessor(this)

        music.stop()
        music = Gdx.audio.newMusic(Gdx.files.internal("Maths_Deadmau5.mp3"))
        music.setLooping(true)
        music.play()
    }

    def spawnPassenger() {
        //Somehow make a new Passenger, will use Chris' combo generator here...
        int makeBob = random.nextInt(20 - 5) + 5
        boolean evilBob = false
        if (makeBob == 15) {
            evilBob = true
        }
        Passenger passenger = new Passenger(random.nextInt(9 - 1) + 1, "BobFriend.png", evilBob)
        if (!terminalController.addPassenger(passenger))
            game.setScreen(new GameOverScreen(game, music))
        lastPassengerTime = TimeUtils.nanoTime()
    }

    @Override
    void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1)
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

        //Logic to Spawn Passengers
        if (TimeUtils.nanoTime() - lastPassengerTime > timeBetweenPassengers)
            spawnPassenger()

        terminalController.update()
        terminalRenderer.render()
    }

    @Override
    boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                terminalController.moveBobLeft()
                break;
            case Input.Keys.RIGHT:
                terminalController.moveBobRight()
                break;
            default:
                terminalController.bob.combo.add(keycode)
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
