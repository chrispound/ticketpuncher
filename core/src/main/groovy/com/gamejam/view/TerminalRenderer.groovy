package com.gamejam.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.gamejam.controller.ComboAnimatorController
import com.gamejam.model.Bob
import com.gamejam.model.Terminal

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:37 PM
 */
class TerminalRenderer {

    Terminal terminal
    SpriteBatch batch
    Texture bobTexture
    Texture backgroundTexture
    Bob bob
    ComboAnimatorController comboAnimatorController
    BitmapFont scoreTitle;
    BitmapFont actualScore;
    Map<String, Texture> passengerTextureMap = [:]
    TextureRegion passenger1
    TextureRegion passenger2
    TextureRegion passenger3
    TextureRegion passenger4
    TextureRegion passenger5
    TextureRegion badPassenger
    TextureRegion deadPassenger

    TerminalRenderer(Terminal terminal) {
        this.terminal = terminal
        bob = terminal.bob
        batch = new SpriteBatch()
        loadTextures()
        comboAnimatorController = new ComboAnimatorController(terminal, this)
        scoreTitle = new BitmapFont();
        actualScore = new BitmapFont();
        actualScore.setColor(Color.CYAN)
        scoreTitle.setColor(Color.CYAN)
    }

    def render() {
        batch.begin()
        batch.draw(backgroundTexture, 0, 0);
        drawBob()
        drawPassengers()
        drawScoreBoard()
        //TODO: There is now logic in our renderer, renderer should only draw things, not update models
        comboAnimatorController.drawCombo()
        comboAnimatorController.updateCombo()
        batch.end()
    }

    def loadTextures() {
        //Load all textures needed...
        bobTexture = new Texture(Gdx.files.internal('bob/bob.png'))
        backgroundTexture = new Texture(Gdx.files.internal('gameJamBackground.png'))

        TextureAtlas passengerAtlas = new TextureAtlas(Gdx.files.internal("packeroutput/passengers.pack"))
        passenger1 = passengerAtlas.findRegion("passenger1")
        passenger2 = passengerAtlas.findRegion("passenger2")
        passenger3 = passengerAtlas.findRegion("passenger3")
        passenger4 = passengerAtlas.findRegion("passenger4")
        passenger5 = passengerAtlas.findRegion("passenger5")
        badPassenger = passengerAtlas.findRegion("badpassenger")
        deadPassenger = passengerAtlas.findRegion("deadpassenger")
    }

    def drawPassengers() {
        terminal.linesMap.values().each { line ->
            line.passengers.each { passenger ->
                batch.draw(findPassengerTexture(passenger.textureName), passenger.position.x, passenger.position.y)
            }
        }
    }

    TextureRegion findPassengerTexture(String textureName) {
        switch (textureName) {
            case 'passenger1':
                return passenger1
            case 'passenger2':
                return passenger2
            case 'passenger3':
                return passenger3
            case 'passenger4':
                return passenger4
            case 'passenger5':
                return passenger5
            case 'badpassenger':
                return badPassenger
            default:
                return deadPassenger
        }
    }

    def drawBob() {
        batch.draw(bobTexture, bob.position.x, bob.position.y)
    }

    private void drawScoreBoard() {
        scoreTitle.draw(batch, "Score", new Float(940), new Float(750))
        actualScore.draw(batch, bob.getScore().toString(), new Float(940), new Float(725))
    }
}
