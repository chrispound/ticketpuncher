package com.gamejam.model

import com.badlogic.gdx.Input
import com.badlogic.gdx.math.Vector2

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:27 AM
 */
class Passenger {
    long points
    ArrayList<Integer> combo
    String textureName
    Vector2 position = new Vector2()
    int delta
    static int MIN = 0
    static int MAX = 3
    Random random = new Random()
    boolean evilBob

    Passenger(long points, ArrayList<Integer> combo, String textureName) {
        this.points = points
        this.textureName = textureName
        this.combo = combo
    }

    Passenger(int delta, String textureName, boolean evilBob) {
        this.points = delta * 2
        this.delta = delta
        this.textureName = textureName
        if (evilBob) {
            this.evilBob = evilBob
            this.textureName = "badpassenger"
            this.points = -5
            this.delta = 8
        }
        generatePassengerComb()
    }

    def void generatePassengerComb() {
        if (combo == null) {
            combo = new ArrayList<Integer>();
        }
        //TODO: Convert to Arcade Machine Controls listed below...
//        def possibleKeys = [Input.Keys.SHIFT_LEFT, Input.Keys.CONTROL_LEFT, Input.Keys.Z,
//        Input.Keys.X, Input.Keys.ENTER, Input.Keys.SPACE]
        def possibleKeys = [Input.Keys.Q, Input.Keys.W, Input.Keys.E,
                Input.Keys.A, Input.Keys.S, Input.Keys.D]
        for (int f = 0; f < delta; f++) {
            combo.add(possibleKeys[random.nextInt(MAX - MIN) + MIN])
        }
    }

    static def increasePossibleButtons() {
        if (MAX < 6) MAX++
    }


}
