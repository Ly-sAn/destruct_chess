package com.company;

public class BoardGame {

    String[][] boardGame;
    Player[] players;

    public BoardGame(String[][] pBoardgame) {
        this.boardGame = pBoardgame;
        //this.boardGame = new String[11][12];
    }

    public String[][] getBoardGame() {
        return boardGame;
    }

    public void setBoardGame(String[][] boardGame) {
        this.boardGame = boardGame;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }
}
