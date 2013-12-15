package com.gamejam.model

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.Array


/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:03 AM
 */
class Terminal {
    Map<String, List<Line>> linesMap
    Bob bob
    Passenger passenger
    Random random

    Terminal() {
        random = new Random()
        linesMap = [open : [new Line(0), new Line(1), new Line(2), new Line(3), new Line(4)], closed : []]
        bob = new Bob(2)
        passenger = new Passenger(random.nextInt(12 - 3) + 3, "BobFriend.png")
    }

    def addPerson(Passenger passenger) {
        if (linesMap.closed.size() == 5) {
            //Handle the game being over???
            println("You Lose!")
            return false;
        }

        Random random = new Random()
        linesMap.open[random.nextInt(linesMap.open.size())].with {
            it.isFull() ? closeLine(it) : it.passengers.add(passenger)
        }

        return true
    }

    def closeLine(Line line) {
        linesMap.open.remove(line)
        linesMap.closed.add(line)
    }
}
