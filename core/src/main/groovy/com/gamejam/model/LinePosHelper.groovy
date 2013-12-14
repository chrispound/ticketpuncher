package com.gamejam.model

import com.badlogic.gdx.math.Vector2

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 10:42 AM
 */
enum LinePosHelper {
    LINE_0(0), LINE_1(1), LINE_2(2), LINE_3(3), LINE_4(4)

    LinePosHelper(int lineNumber) {
        this.lineNumber = lineNumber
    }
    int lineNumber

    Vector2 getLinePosition(int linePosition) {
        return new Vector2(
                (PosHelper.gameStageStartX + (lineNumber * (PosHelper.lineSeparation + PosHelper.lineHeightWidth))).toFloat(),
                (PosHelper.lineStartY - (linePosition * PosHelper.lineHeightWidth)).toFloat())
    }
}
