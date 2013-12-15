package com.gamejam.controller

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.gamejam.model.Terminal
import com.gamejam.screens.GameScreen
import com.gamejam.view.TerminalRenderer

/**
 * Created by Chris on 12/14/13.
 *
 *
 */
class ComboAnimatorController {

    Terminal terminal

    //gets me bob
    //gets me controller
    //i really want to use groovy now.
    GameScreen game
    /**
     * Regular Btn Textures
     */
    static Texture lCtrlTexture = new Texture(Gdx.files.internal("buttons/btn_press_lctrl.png"))
    static Texture lShiftTexture = new Texture(Gdx.files.internal("buttons/btn_press_lshift.png"))
    static Texture xTexture = new Texture(Gdx.files.internal("buttons/btn_press_x.png"))
    static Texture zTexture = new Texture(Gdx.files.internal("buttons/btn_press_z.png"))
    static Texture enterTexture = new Texture(Gdx.files.internal("buttons/btn_press_enter.png"))
    static Texture spaceTexture = new Texture(Gdx.files.internal("buttons/btn_press_space.png"))
    /**
     * Error Btn Textures
     */
//    static Texture lCtrlTexturewrong = new Texture(Gdx.files.internal(("buttons/btn_wrong_lctrl.png")))
//    static Texture lShiftTexturewrong = new Texture(Gdx.files.internal(("buttons/btn_wrong_lshift.png")))
//    static Texture lEnterTexturewrong = new Texture(Gdx.files.internal(("buttons/btn_wrong_enter.png")))
//    static Texture zTexturewrong = new Texture(Gdx.files.internal(("buttons/btn_wrong_z.png")))
//    static Texture xTexturewrong = new Texture(Gdx.files.internal(("buttons/btn_wrong_x.png")))
//    static Texture spaceTexturewrong = new Texture(Gdx.files.internal(("buttons/btn_wrong_space.png")))

    /**
     * Good Btn Tetures
     */

    static Texture lCtrlTextureGood = new Texture(Gdx.files.internal(("buttons/btn_good_lctrl.png")))
    static Texture lShiftTextureGood = new Texture(Gdx.files.internal(("buttons/btn_good_lshift.png")))
    static Texture enterTextureGood = new Texture(Gdx.files.internal(("buttons/btn_good_enter.png")))
    static Texture zTextureGood = new Texture(Gdx.files.internal(("buttons/btn_good_z.png")))
    static Texture xTextureGood = new Texture(Gdx.files.internal(("buttons/btn_good_x.png")))
    static Texture spaceTextureGood = new Texture(Gdx.files.internal(("buttons/btn_good_space.png")))

    static final POS_X = 5
    static final POS_Y_START = 645
    static final POSY_Y_MULTIPLIER = 84
    TerminalRenderer renderer

    ComboAnimatorController(Terminal terminal, TerminalRenderer renderer) {
        this.terminal = terminal
        this.renderer = renderer
    }

    def update() {
        //decide what to draw

        drawCombo()

    }
    /**
     * check which sequence in the combo was pressed
     * check if it was passed
     * get the key image from our currentPassenger
     * ?????
     * profit
     */
    def updateCombo() {
        ArrayList<Integer> bobCombo = terminal.bob.combo
        ArrayList<Integer> passengerCombo = terminal.currentPassenger.combo
        Texture updatedTexture
        if (passengerCombo.size() > 0) {
            for (int f = 0; f < bobCombo.size(); f++) {
                if (!bobCombo.get(f).equals(passengerCombo.get(f))) {
                    terminal.bob.combo = new ArrayList<Integer>();
//                updatedTexture = getErrorComboImageTexture(terminal.currentPassenger.combo.get(mostRecentComboPosition))
//                TextureRegion btnRegion = new TextureRegion(updatedTexture, 88, 45)
//                renderer.batch.draw(btnRegion, POS_X, (POS_Y_START - POSY_Y_MULTIPLIER * mostRecentComboPosition))
                    //kick off btn update
                    break;
                } else {
                    for (int i = 0; i < bobCombo.size(); i++) {
                        updatedTexture = getGoodComboImageTexture(terminal.currentPassenger.combo.get(i))
                        TextureRegion btnRegion = new TextureRegion(updatedTexture, 88, 45)
                        renderer.batch.draw(btnRegion, POS_X, (POS_Y_START - POSY_Y_MULTIPLIER * i + 1))
                    }
                    if (f == (passengerCombo.size() - 1)) {
                        bobCombo = new ArrayList<Integer>();
                        //kick off btn update
                    }
                }
            }
        }
    }

    def drawCombo() {
//update combo as user does stuff.
        int tempY = POS_Y_START
        for (int f = 0; f < terminal.currentPassenger.combo.size(); f++) {
            Texture btnTexture = getComboImageTexture(terminal.currentPassenger.combo.get(f))
            TextureRegion btnRegion = new TextureRegion(btnTexture, 88, 45)
            renderer.batch.draw(btnRegion, POS_X, tempY)
            //UPDATE POS
            tempY = tempY - POSY_Y_MULTIPLIER
        }
    }

    static Texture getComboImageTexture(int key) {
        switch (key) {

            case Input.Keys.CONTROL_LEFT:
            case Input.Keys.Q:
                return lCtrlTexture
            case Input.Keys.SHIFT_LEFT:
            case Input.Keys.A:
                return lShiftTexture
            case Input.Keys.ENTER:
            case Input.Keys.W:
                return enterTexture
            case Input.Keys.Z:
            case Input.Keys.S:
                return zTexture
            case Input.Keys.X:
            case Input.Keys.D:
                return xTexture
            case Input.Keys.SPACE:
            case Input.Keys.E:
                return spaceTexture
            default:
                return null
        }
    }

    static Texture getGoodComboImageTexture(int key) {
        switch (key) {

            case Input.Keys.CONTROL_LEFT:
            case Input.Keys.Q:
                return lCtrlTextureGood
            case Input.Keys.SHIFT_LEFT:
            case Input.Keys.A:
                return lShiftTextureGood
            case Input.Keys.ENTER:
            case Input.Keys.W:
                return enterTextureGood
            case Input.Keys.Z:
            case Input.Keys.S:
                return zTextureGood
            case Input.Keys.X:
            case Input.Keys.D:
                return xTextureGood
            case Input.Keys.SPACE:
            case Input.Keys.E:
                return spaceTextureGood
            default:
                return null
        }
    }

//    static Texture getErrorComboImageTexture(int key) {
//        switch (key) {
//
//            case Input.Keys.CONTROL_LEFT:
//                return lCtrlTexturewrong
//            case Input.Keys.SHIFT_LEFT:
//                return lShiftTexturewrong
//            case Input.Keys.ENTER:
//                return lEnterTexturewrong
//            case Input.Keys.Z:
//                return zTexturewrong
//            case Input.Keys.X:
//                return xTexturewrong
//            case Input.Keys.SPACE:
//                return spaceTexturewrong
//            default:
//                return null
//        }
//    }

}
