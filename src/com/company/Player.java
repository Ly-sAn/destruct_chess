package com.company;

import java.util.Random;

/**
 * Class "Player" which defines a player, represented by a name and coordinates.
 */
public class Player {

    public final String pseudo;
    public int positionX;
    public int positionY;

    public Player(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
