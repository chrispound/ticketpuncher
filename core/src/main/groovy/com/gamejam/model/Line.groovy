package com.gamejam.model

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:03 AM
 */
class Line {
    def lineNumber
    List<Passenger> people = []
    def maxLineSize = 10

    Line(lineNumber) {
        this.lineNumber = lineNumber
    }

    def isFull() {
        people.size() == maxLineSize
    }

    @Override
    boolean equals(Object obj) {
        this.lineNumber == ((Line)obj).lineNumber
    }
}