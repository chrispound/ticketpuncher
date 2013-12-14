package com.gamejam.screens

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.gamejam.game.GameJam

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 13-Dec-2013
 * at 8:47 PM
 */
class GameScreen implements Screen {

    final GameJam game
    private SpriteBatch batch;

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
}
