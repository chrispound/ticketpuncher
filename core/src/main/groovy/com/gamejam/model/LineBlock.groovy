package com.gamejam.model

import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2


/**
 * Created by 
 * Matthew Fitzpatrick 
 * on 13-Dec-2013
 * at 9:27 PM
 */
class LineBlock {

    Vector2 position
    Rectangle bounds = new Rectangle()

    LineBlock(Vector2 position) {
        this.position = position
        this.bounds.x = this.position.x
        this.bounds.y = this.position.y
        this.bounds.width = 64
        this.bounds.height = 64
    }
}
