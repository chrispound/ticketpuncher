package com.gamejam.model

import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:27 AM
 */
class Passenger {
    long points
    ArrayList<Integer> combo
    Texture passengerTexture

    Passenger(long points, ArrayList<Integer> combo, Texture passengerTexture) {
        this.points = points
        this.combo = getPassengerCombo()
        this.passengerTexture = passengerTexture
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
