package com.gamejam.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
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
    Bob bob

    TerminalRenderer(Terminal terminal) {
        this.terminal = terminal
        bob = terminal.bob
        batch = new SpriteBatch()
        loadTextures()
    }

    def render() {
        batch.begin()

        batch.draw(deskTexture, gameStageStartX.toFloat(), (gameStageStartY - bobWidthHeight).toFloat())
        drawBob()
        drawPassengers()

        batch.end()
    }

    def loadTextures() {
        //Load all textures needed...
        bobTexture = new Texture(Gdx.files.internal('bob.png'))
        lineTexture = new Texture(Gdx.files.internal('templine.png'))
        deskTexture = new Texture(Gdx.files.internal('desk.png'))

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
}
