package com.company;

public class Player {

    String pseudo;
    int positionX;
    int positionY;

    public Player(String pseudo, int positionX, int positionY) {
        this.pseudo = pseudo;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Player() {
        this.pseudo = "jean";
        this.positionX = 5;
        this.positionY = 5;
    }


    public String getPseudo() {
        return pseudo;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


}
