package com.gamejam.model

import com.badlogic.gdx.graphics.Texture

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:27 AM
 */
class Passenger {
    long points
    def combo
    Texture passengerTexture

    Passenger(long points, combo, Texture passengerTexture) {
        this.points = points
        this.combo = combo
        this.passengerTexture = passengerTexture
    }
}
