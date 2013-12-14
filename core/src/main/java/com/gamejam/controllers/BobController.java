package com.gamejam.controllers;

import com.gamejam.actors.Bob;
import com.gamejam.views.Terminal;

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
    private boolean mapUpdatable = true;


    public BobController(Terminal terminal) {

        this.terminal = terminal;
        this.bobTheAlmighty = terminal.getBobTheAlmightyPuncherOfAllThings();
    }

    public void setMapUpdatable(boolean p) {
        this.mapUpdatable = p;
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
        if (mapUpdatable) {
            input.put(Keys.LEFT, true);
            stopMovingRight();
            mapUpdatable = false;
        }
    }

    public void movingRight() {
        if (mapUpdatable) {
            mapUpdatable = false;
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
            int currentRow = bobTheAlmighty.getCurrentRow();
            if (left && currentRow != END_OF_LEFT) {

                bobTheAlmighty.setCurrentRow(--currentRow);

            } else if (right && currentRow != END_OF_RIGHT) {
                bobTheAlmighty.setCurrentRow(++currentRow);
            }

        }
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

