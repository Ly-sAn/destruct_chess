package com.company;

import java.util.Random;

/**
 * Class "Player" which defines a player, represented by a name and coordinates.
 */
public class Player {

    public final String pseudo;
    private int positionX;
    private int positionY;
    private String render;

    public Player(String pseudo, int positionX, int positionY, String render) {
        this.pseudo = pseudo;
        this.positionX = positionX;
        this.positionY = positionY;
        this.render = render;
    }

    public String getRender(){
        return render;
    }

    /**
     * Function who set if player is on this case
     * @param positionX
     * @param positionY
     * @return
     */
    public boolean isOn(int positionX, int positionY)
    {
        return this.positionX == positionX && this.positionY == positionY;
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
