package com.gamejam.view

import com.badlogic.gdx.graphics.g2d.SpriteBatch
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

    TerminalRenderer(Terminal terminal) {
        this.terminal = terminal
        batch = new SpriteBatch()
    }

    public void render() {
        drawBob()
        draw
    }
}
