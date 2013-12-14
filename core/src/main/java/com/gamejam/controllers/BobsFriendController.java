package com.gamejam.controllers;

import com.gamejam.actors.BobsFriend;
import com.gamejam.model.Terminal;


/**
 * Created with IntelliJ IDEA.
 * User: e590436
 * Date: 12/14/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class BobsFriendController {


    private static final int END_OF_LINE = 0;
    private static final int BEG_OF_LINE = 9;
    private BobsFriend bobsFriend;
    private Terminal terminal;
    private boolean bobFriendAbleToMove = true;
    private boolean mapUpdatable = true;


    public BobsFriendController(Terminal terminal) {
        this.terminal = terminal;
//        this.bobsFriend = terminal.getBobsFriend();
    }

    public void setMapUpdatable(boolean p) {
        this.mapUpdatable = p;
    }


}
