package com.gamejam.controller

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.gamejam.screens.GameScreen
import com.gamejam.model.Terminal

/**
 * Created by Chris on 12/14/13.
 *
 *
 */
class ComboAnimatorController {

    Terminal terminal
    GameScreen game
   static Texture lCtrlTexture = new Texture(Gdx.files.internal("buttons/btn_press_lctrl.png"))
   static Texture lShiftTexture = new Texture(Gdx.files.internal("buttons/btn_press_lshift.png"))
   static Texture xTeture = new Texture(Gdx.files.internal("buttons/btn_press_x.png"))
   static Texture zTexture = new Texture(Gdx.files.internal("buttons/btn_press_z.png"))
   static Texture enterTexture = new Texture(Gdx.files.internal("buttons/btn_press_enter.png"))
   static Texture spaceTexture = new Texture(Gdx.files.internal("buttons/btn_press_space.png"))


    ComboAnimatorController(Terminal terminal, GameScreen gameScreen) {
        this.terminal = terminal
        this.game = gameScreen
    }

    def animateButtons() {

    }

    def drawError() {

    }

    def drawGood() {

    }

    def drawCombo(SpriteBatch batch) {
        //get passenger combo
        //draw passenger combo
        int tempX = 10
        int tempY = 200

        for (int f = 0; f < terminal.passenger.combo.size(); f++) {
            Texture btnTexture = getComboImageTexture(terminal.passenger.combo.get(f))
            TextureRegion btnRegion = new TextureRegion(btnTexture, 88, 45 )
            game.spriteBatch.draw(btnRegion, tempX, tempY)
            //UPDATE POS
            tempY = tempY + 84
        }
    }

    static Texture getComboImageTexture(int key) {
        switch (key) {

            case Input.Keys.CONTROL_LEFT:
                return lCtrlTexture
            case Input.Keys.SHIFT_LEFT:
                return lShiftTexture
            case Input.Keys.ENTER:
                return enterTexture
            case Input.Keys.Z:
                return zTexture
            case Input.Keys.X:
                return xTeture
            case Input.Keys.SPACE:
                return spaceTexture
                break;
        }


        return ""
    }

}
