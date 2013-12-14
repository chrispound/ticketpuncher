package com.badlogic.gradletest

import com.gamejam.model.PosHelper

/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 14-Dec-2013
 * at 10:34 AM
 */
class Tester {
    public static void main(String[] args) {
        PosHelper.LinePosition.each {
            println(it)
        }
    }
}

