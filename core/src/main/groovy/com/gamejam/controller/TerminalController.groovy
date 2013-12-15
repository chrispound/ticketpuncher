package com.gamejam.controller

import com.gamejam.model.Bob
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
    ArrayList<Integer> bobCombo = new ArrayList<Integer>()
    ArrayList<Integer> passengerCombo
    def movementProcessed = true


    TerminalController(Terminal terminal) {
        this.terminal = terminal
        this.bob = terminal.bob
    }


    def update() {
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
        ArrayList<Integer> passengerCombo = getPassengerCombo()
        for (int f = 0; f < bobCombo.size(); f++) {
            if (!bobCombo.get(f).equals(passengerCombo.get(f))) {
                bobCombo = new ArrayList<Integer>()
                System.out.println("Combo Was Wrong! We Where So WRONG")
                break
            } else {

                System.out.println("Combo was Good!")
                if (f == (passengerCombo.size() - 1)) {
                    bobCombo = new ArrayList<Integer>();
                    System.out.println("COMBO COMPLETE: Give Bob Points");
                    this.bobTheAlmighty.updateScore();
                    this.bobTheAlmighty.updateTicketsPunched();
                }
            }
        }
    }

    public void bobIsPunchingATicket(int key) {
        this.bobCombo.add(key)
    }
}
