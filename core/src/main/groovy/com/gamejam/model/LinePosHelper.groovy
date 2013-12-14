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

    def getLinePosition(int linePosition) {
        return new Vector2((PositionHelper.gameStageStartX + (lineNumber * (PositionHelper.lineSeparation + PositionHelper.lineHeightWidth))).toFloat(),
                (PositionHelper.lineStartY - (linePosition * 64)).toFloat())
    }
}
