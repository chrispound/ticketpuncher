package com.gamejam.screens

import com.badlogic.gdx.Screen
import com.gamejam.game.GameJam

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 13-Dec-2013
 * at 8:47 PM
 */
class GameScreen implements Screen {

    final GameJam game

    GameScreen(GameJam game) {
        this.game = game
    }

    @Override
    void render(float delta) {

    }

    @Override
    void resize(int width, int height) {

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
}
