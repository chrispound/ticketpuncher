package com.gamejam.controllers;

import com.gamejam.actors.Bob;
import com.gamejam.views.World;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris on 12/13/13.
 * Controll manager and listener for the main player Bob
 */
public class BobController {

    private static Map<Keys, Boolean> input = new HashMap<Keys, Boolean>();
    private Bob bobTheAlmighty;
    private World world;
    private static final int END_OF_LEFT = 1;
    private static final int END_OF_RIGHT = 5;


    public BobController(World world) {

        this.world = world;
        this.bobTheAlmighty = world.getBobTheAlmighty();
    }

    enum Keys {
        LEFT, RIGHT
    }

    static {
        input.put(Keys.LEFT, false);
        input.put(Keys.RIGHT, false);
    }
    //esc = escape exit

    //arrows handle user direction

    //USER BUTTONS
    //l-ctrl
    //enter
    //space
    //l-shift
    //z
    //x

    public void update(float delta) {
        processInputMapDeterminePosition();
    }


    //ARCADE BUTTONS
    //1 //2 player start and join
    //5 //6 player coin buttons
    public void movingLeft() {
        input.put(Keys.LEFT, true);
        input.put(Keys.RIGHT, false);
    }

    public void movingRight() {
        input.put(Keys.RIGHT, true);
        input.put(Keys.LEFT, false);
    }

    public void stopMovingRight() {
        input.put(Keys.RIGHT, false);
    }

    public void stopMovingLeft() {
        input.put(Keys.LEFT, false);
    }

    public void processInputMapDeterminePosition() {
        boolean left = input.get(Keys.LEFT);
        boolean right = input.get(Keys.RIGHT);
        int currentRow = bobTheAlmighty.getCurrentRow();
        if (left && currentRow != END_OF_LEFT) {

            bobTheAlmighty.setCurrentRow(--currentRow);

        } else if (right && currentRow != END_OF_RIGHT) {
            bobTheAlmighty.setCurrentRow(++currentRow);
        }


    }
}
