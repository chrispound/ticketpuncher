package com.gamejam.model
/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:03 AM
 */
class Terminal {
    Map<String, Line> linesMap
    Bob bob
    Passenger currentPassenger
    Random random

    Terminal() {
        random = new Random()
        linesMap = ['0': new Line(0), '1' : new Line(1), '2' : new Line(2), '3' : new Line(3), '4' : new Line(4)]
        bob = new Bob(2)
        updateCurrentPassenger()
    }

    def addPerson(Passenger passenger) {
        if (linesMap.values().findAll{it.closed}.size() == 5) {
            //Handle the game being over???
            println("You Lose!")
            return false;
        }

        linesMap[random.nextInt(linesMap.size()).toString()].with {
            it.isFull() ? it.closed = true : it.passengers.add(passenger)
        }

        return true
    }

    def updateCurrentPassenger() {
        def currentLine = linesMap[bob.currentLine.toString()]
        currentPassenger =  currentLine.passengers ? currentLine.passengers[0] : new Passenger(0, [], "this is not an image")
    }
}
