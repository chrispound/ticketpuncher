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

    /**
     * Method to add a passenger to a line's passenger list.
     * A line is closed when the 11th passenger is attempted to be added
     *
     * @param passenger the passenger to add, dur
     * @returns true if the game should continue, false if the game is over because there are no open lines
     */
    def addPerson(Passenger passenger) {
        if (linesMap.values().findAll{it.closed}.size() == 5) {
            return false;
        }

        def openLines = linesMap.values().findAll { !it.closed }
        openLines[random.nextInt(openLines.size())].with {
            it.isFull() ? it.closed = true : it.passengers.add(passenger)
        }

        return true
    }

    def updateCurrentPassenger() {
        def currentLine = linesMap[bob.currentLineNumber.toString()]
        currentPassenger =  currentLine.passengers ? currentLine.passengers[0] : new Passenger(0, [], "this is not an image")
    }

    def getCurrentLine() {
        linesMap[bob.currentLineNumber.toString()]
    }
}
