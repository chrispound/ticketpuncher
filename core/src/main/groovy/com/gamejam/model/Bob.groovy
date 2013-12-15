package com.gamejam.model

import com.badlogic.gdx.math.Vector2

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 4:04 PM
 */
class Bob {
    Vector2 position
    int currentLineNumber
    ArrayList<Integer> combo = new ArrayList<>()
    int score
    int ticketsPunched

    public Bob(int currentLineNumber) {
        this.position = new Vector2()
        this.setCurrentLineNumber(currentLineNumber)
        this.score = 0
        this.ticketsPunched = 0
    }

    public void setCurrentLineNumber(int newLineNumber) {
        this.currentLineNumber = newLineNumber;
        updatePosition();
    }

    private void updatePosition() {
        switch (currentLineNumber) {
            case 0:
                position.set(LinePosHelper.LINE_0.getLinePosition(0).x, (LinePosHelper.LINE_0.getLinePosition(0).y + 84).toFloat());
                break;
            case 1:
                position.set(LinePosHelper.LINE_1.getLinePosition(0).x, (LinePosHelper.LINE_1.getLinePosition(0).y + 84).toFloat());
                break;
            case 2:
                position.set(LinePosHelper.LINE_2.getLinePosition(0).x, (LinePosHelper.LINE_2.getLinePosition(0).y + 84).toFloat());
                break;
            case 3:
                position.set(LinePosHelper.LINE_3.getLinePosition(0).x, (LinePosHelper.LINE_3.getLinePosition(0).y + 84).toFloat());
                break;
            case 4:
                position.set(LinePosHelper.LINE_4.getLinePosition(0).x, (LinePosHelper.LINE_4.getLinePosition(0).y + 84).toFloat());
                break;
        }
    }
    public void updateScore(long passengerPoints) {
        this.score += passengerPoints
    }
    public void updateTicketsPunched() {
        this.ticketsPunched++
    }
}
