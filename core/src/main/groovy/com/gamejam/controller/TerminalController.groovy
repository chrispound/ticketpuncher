package com.gamejam.controller

import com.gamejam.model.Bob
import com.gamejam.model.LinePosHelper
import com.gamejam.model.Passenger
import com.gamejam.model.Terminal

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 3:01 PM
 */
class TerminalController {
    private static final int END_OF_LEFT = 0
    private static final int END_OF_RIGHT = 4
    def input = [left: false, right: false]
    Bob bob
    Terminal terminal
    def movementProcessed = true

    TerminalController(Terminal terminal) {
        this.terminal = terminal
        this.bob = terminal.bob
    }

    def update() {

        //Bob Stuff...
        if (input.left && !movementProcessed)
            if (bob.currentLineNumber != END_OF_LEFT) {
                bob.currentLineNumber -= 1
                movementProcessed = true
            }

        if (input.right && !movementProcessed)
            if (bob.currentLineNumber != END_OF_RIGHT) {
                bob.currentLineNumber += 1
                movementProcessed = true
            }

        //Update all Passengers in Open Lines
        terminal.linesMap.values().each { line ->
            line.passengers.eachWithIndex { passenger, idx ->
                switch (line.lineNumber) {
                    case 0:
                        passenger.position = LinePosHelper.LINE_0.getLinePosition(idx)
                        break;
                    case 1:
                        passenger.position = LinePosHelper.LINE_1.getLinePosition(idx)
                        break;
                    case 2:
                        passenger.position = LinePosHelper.LINE_2.getLinePosition(idx)
                        break;
                    case 3:
                        passenger.position = LinePosHelper.LINE_3.getLinePosition(idx)
                        break;
                    case 4:
                        passenger.position = LinePosHelper.LINE_4.getLinePosition(idx)
                        break;
                }
            }
        }

        terminal.updateCurrentPassenger()
    }

    def addPassenger(Passenger passenger) {
        terminal.addPerson(passenger)
    }

//arrows handle user direction
//USER BUTTONS
//x
//z
//l-shift
//space
//enter
//l-ctrl
//esc = escape exit
//ARCADE BUTTONS
//1 //2 player start and join
//5 //6 player coin buttons
    public void moveBobLeft() {
        movementProcessed = false
        input.right = false
        input.left = true
    }

    public void moveBobRight() {
        movementProcessed = false
        input.left = false
        input.right = true
    }

    def stopMovingBob() {
        movementProcessed = true
        input.left = false
        input.right = false
    }

    public void checkIfComboIsCorrect() {
        //check currentPassenger ticket
        ArrayList<Integer> passengerCombo = terminal.currentPassenger.combo
        if (passengerCombo.size() > 0) {
            for (int f = 0; f < terminal.bob.combo.size(); f++) {
                if (f == (passengerCombo.size() - 1)) {
                    terminal.bob.combo = new ArrayList<Integer>();
                    this.terminal.bob.updateScore(terminal.currentPassenger.points);
                    this.terminal.bob.updateTicketsPunched();
                    popCurrentPassenger()
                }
            }

        }
    }

    def popCurrentPassenger() {
        def currentLine = terminal.bob.currentLineNumber
        terminal.linesMap[currentLine.toString()].passengers.remove(0)
    }


}
