package com.gamejam.controllers;

import com.gamejam.actors.Bob;
import com.gamejam.model.Terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris on 12/13/13.
 * Controll manager and listener for the main player Bob
 */
public class BobController {

    private static final int END_OF_LEFT = 1;
    private static final int END_OF_RIGHT = 5;
    private Map<Keys, Boolean> input = new HashMap<Keys, Boolean>();
    private Bob bobTheAlmighty;
    private Terminal terminal;
    private boolean bobAbleToMove = true;
    private boolean mapUpdateable = true;
    private ArrayList<Integer> bobCombo = new ArrayList<Integer>();


    public BobController(Terminal terminal) {

        this.terminal = terminal;
        this.bobTheAlmighty = terminal.getBobTheAlmightyPuncherOfAllThings();
    }

    public void setMapUpdateable(boolean p) {
        this.mapUpdateable = p;
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
    public void movingLeft() {
        if (mapUpdateable) {
            input.put(Keys.LEFT, true);
            stopMovingRight();
            mapUpdateable = false;
        }
    }

    public void movingRight() {
        if (mapUpdateable) {
            mapUpdateable = false;
            input.put(Keys.RIGHT, true);
            stopMovingLeft();
        }
    }

    public void stopMovingRight() {
        input.put(Keys.RIGHT, false);
    }

    public void stopMovingLeft() {
        input.put(Keys.LEFT, false);
    }

    public void processInputMapDeterminePosition() {
        boolean left = false;
        boolean right = false;
        if (isBobAbleToMove()) {
            bobAbleToMove = false;
            if (input.get(Keys.LEFT) != null) {
                left = input.get(Keys.LEFT);
            }
            if (input.get(Keys.RIGHT) != null) {
                right = input.get(Keys.RIGHT);
            }
            int currentRow = bobTheAlmighty.getCurrentLine();
            if (left && currentRow != END_OF_LEFT) {

                bobTheAlmighty.setCurrentLine(--currentRow);

            } else if (right && currentRow != END_OF_RIGHT) {
                bobTheAlmighty.setCurrentLine(++currentRow);
            }

        }
    }

    public void checkIfComboIsCorrect() {
        //check passenger ticket
        ArrayList<Integer> passengerCombo = terminal.passenger.getPassengerCombo();
        for (int f = 0; f < bobCombo.size(); f++) {
            if (!bobCombo.get(f).equals(passengerCombo.get(f))) {
                bobCombo = new ArrayList<Integer>();
                System.out.println("Combo Was Wrong! We Where So WRONG");
                break;
            } else {

                System.out.println("Combo was Good!");
                if (f == (passengerCombo.size() - 1)) {
                    bobCombo = new ArrayList<Integer>();
                    System.out.println("COMBO COMPLETE: Give Bob Points");
                }
            }
        }


    }

    public void bobIsPunchingATicket(int key) {
        this.bobCombo.add(key);
    }

    public boolean isBobAbleToMove() {
        return bobAbleToMove;
    }

    public void setBobAbleToMove(Boolean bobAbleToMove) {
        this.bobAbleToMove = bobAbleToMove;
    }

    enum Keys {
        LEFT, RIGHT
    }
}

