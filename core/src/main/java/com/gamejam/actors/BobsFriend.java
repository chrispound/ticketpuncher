package com.gamejam.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: e590436
 * Date: 12/14/13
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class BobsFriend {

    enum State {
        MOVING,
        IDLE;
    }

    boolean isFrontOfLine = false;
    ArrayList<Integer> combo;
    Integer points;
    Vector2 acceleration = new Vector2();
    Vector2 velocity = new Vector2();
    Rectangle bounds = new Rectangle();
    int currentRow = 3;
    float stateTime = 0;

    public BobsFriend(Vector2 position, ArrayList<Integer> combo, boolean isFrontOfLine) {
        this.bounds.x = position.x;
        this.bounds.y = position.y;
        this.combo = combo;
        this.isFrontOfLine = isFrontOfLine;
    }

    public BobsFriend() {

    }

    public void update(float delta) {
        stateTime += delta;
//        position.add(velocity.cpy().scl(delta));
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentRow() {
        return this.currentRow;
    }
}
