package com.gamejam.controller

import com.gamejam.model.Bob
import com.gamejam.model.LinePosHelper
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
            if (bob.currentLine != END_OF_LEFT) {
                bob.currentLine -= 1
                movementProcessed = true
            }

        if (input.right && !movementProcessed)
            if (bob.currentLine != END_OF_RIGHT) {
                bob.currentLine += 1
                movementProcessed = true
            }

        //Update all Passengers in Open Lines
        terminal.linesMap.open.each { line ->
            line.passengers.eachWithIndex { passenger, idx ->
                switch (line.lineNumber) {
                    case 0:
                        passenger.position = LinePosHelper.LINE_0.getLinePosition(idx)
                        break;
                    case 1:
                        passenger.position = LinePosHelper.LINE_0.getLinePosition(idx)
                        break;
                    case 2:
                        passenger.position = LinePosHelper.LINE_0.getLinePosition(idx)
                        break;
                    case 3:
                        passenger.position = LinePosHelper.LINE_0.getLinePosition(idx)
                        break;
                    case 4:
                        passenger.position = LinePosHelper.LINE_0.getLinePosition(idx)
                        break;
                }
            }
        }


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
        //check passenger ticket
        ArrayList<Integer> passengerCombo = terminal.passenger.combo
        for (int f = 0; f < terminal.bob.combo.size(); f++) {
            if (!terminal.bob.combo.get(f).equals(passengerCombo.get(f))) {
                terminal.bob.combo = new ArrayList<Integer>()
                System.out.println("Combo Was Wrong! We Where So WRONG")
                break
            } else {

                System.out.println("Combo was Good!")
                if (f == (passengerCombo.size() - 1)) {
                    terminal.bob.combo = new ArrayList<Integer>();
                    System.out.println("COMBO COMPLETE: Give Bob Points");
                    //this.terminal.bob.updateScore(terminal.linesMap);
                    this.terminal.bob.updateTicketsPunched();
                }
            }
        }
    }

    public void bobIsPunchingATicket(int key) {
        this.terminal.bob.combo.add(key)
    }
}
