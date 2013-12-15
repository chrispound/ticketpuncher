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
    int delta
    int MIN = 0
    int MAX = 6

    Passenger(long points, ArrayList<Integer> combo, String textureName) {
        this.points = points
        this.textureName = textureName
        this.combo = combo
    }

    Passenger(int delta, String textureName) {
        this.points = delta * 2
        this.delta = delta
        generatePassengerComb()
        this.textureName = textureName
    }

    def void generatePassengerComb() {
        if(combo == null){
            combo = new ArrayList<Integer>();
        }
        def possibleKeys = [Input.Keys.SHIFT_LEFT, Input.Keys.CONTROL_LEFT, Input.Keys.Z,
        Input.Keys.X, Input.Keys.ENTER, Input.Keys.SPACE]
        println "random number is: " + delta
        Random random = new Random()
        //generate size. generate
        for (int f = 0; f < delta; f++) {
                 //i need to generate a random number here just
            combo.add(possibleKeys[random.nextInt(MAX - MIN) + MIN])
        }


    }

}
