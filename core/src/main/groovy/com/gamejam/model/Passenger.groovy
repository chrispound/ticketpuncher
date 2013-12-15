package com.gamejam.model

import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
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

    Passenger(long points, ArrayList<Integer> combo, String textureName) {
        this.points = points
        this.combo = getPassengerCombo()
        this.textureName = textureName
    }

    public ArrayList<Integer> getPassengerCombo() {
        ArrayList<Integer> passengerCombo = new ArrayList<>();
        passengerCombo.add(Input.Keys.CONTROL_LEFT);
        passengerCombo.add(Input.Keys.SHIFT_LEFT);
        passengerCombo.add(Input.Keys.SHIFT_LEFT);
        passengerCombo.add(Input.Keys.X);
        return passengerCombo;
    }
}
