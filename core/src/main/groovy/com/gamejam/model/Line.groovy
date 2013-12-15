package com.gamejam.model

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 12:03 AM
 */
class Line {
    def lineNumber
    List<Passenger> passengers = []
    def maxLineSize = 10
    def closed = false

    Line(lineNumber) {
        this.lineNumber = lineNumber
    }

    def isFull() {
        passengers.size() == maxLineSize
    }

    @Override
    boolean equals(Object obj) {
        this.lineNumber == ((Line)obj).lineNumber
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineNumber=" + lineNumber +
                '}';
    }
}
