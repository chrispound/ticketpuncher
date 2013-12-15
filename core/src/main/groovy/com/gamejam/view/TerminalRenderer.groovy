package com.gamejam.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.gamejam.controller.ComboAnimatorController
import com.gamejam.model.Bob
import com.gamejam.model.Terminal

import static com.gamejam.model.PosHelper.*
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
    Texture lineTexture
    Texture deskTexture
    Texture backgroundTexture
    Bob bob
    ComboAnimatorController comboAnimatorController
    BitmapFont scoreTitle;
    BitmapFont actualScore;

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
        batch.draw(deskTexture, gameStageStartX.toFloat(), (gameStageStartY - bobWidthHeight).toFloat())
        batch.draw(backgroundTexture, 0,0);
        drawBob()
        drawPassengers()
        drawScoreBoard()
        comboAnimatorController.drawCombo()
        comboAnimatorController.updateCombo()
        batch.end()
    }

    def loadTextures() {
        //Load all textures needed...
        bobTexture = new Texture(Gdx.files.internal('bob.png'))
        lineTexture = new Texture(Gdx.files.internal('templine.png'))
        deskTexture = new Texture(Gdx.files.internal('desk.png'))
        backgroundTexture = new Texture(Gdx.files.internal('gameJamBackground.png'))
    }

    def drawPassengers() {
        (terminal.linesMap.open + terminal.linesMap.closed).each { line ->
            line.passengers.each { passenger ->
                batch.draw(passenger.texture, passenger.position.x, passenger.position.y)
            }
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
