package com.gamejam.model

import com.badlogic.gdx.graphics.Texture
import com.gamejam.actors.Bob
import com.gamejam.actors.BobsFriend
import com.gamejam.model.Line
import com.gamejam.model.Passenger

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:03 AM
 */
class Terminal {
    Map<String, List<Line>> linesMap
    Bob bobTheAlmightyPuncherOfAllThings
    BobsFriend bobsFriend
    public Passenger passenger

    Terminal() {
        linesMap = [open : [new Line(1), new Line(2), new Line(3), new Line(4), new Line(5)], closed : []]
        bobTheAlmightyPuncherOfAllThings = new Bob()
        bobsFriend = new BobsFriend()
        passenger = new Passenger(200, new ArrayList<Integer>(), new Texture("BobFriend.png") )
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
