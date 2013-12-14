package com.gamejam.model

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:03 AM
 */
class Terminal {
    Map<String, List<Line>> linesMap
    Bob bob

    Terminal() {
        linesMap = [open : [new Line(0), new Line(1), new Line(2), new Line(3), new Line(4)], closed : []]
        bob = new Bob(2)
    }

    def addPerson(Passenger passenger) {
        if (linesMap.closed.size() == 5) {
            //Handle the game being over???
            println("You Lose!")
            return;
        }

        Random random = new Random()
        linesMap.open[random.nextInt(linesMap.open.size())].with {
            it.isFull() ? closeLine(it) : it.people.add(passenger)
        }
    }

    def closeLine(Line line) {
        linesMap.open.remove(line)
        linesMap.closed.add(line)
    }
}
