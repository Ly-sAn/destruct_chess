package com.company;

import java.util.Scanner;

public class Game {

    public static Scanner sc = new Scanner(System.in);

    public static BoardGame movePlayer(BoardGame boardGame, Player player, int positionX, int positionY){

        //modifier les coordonnées du joueur
        player.setPositionX(positionX);
        player.setPositionY(positionY);

        //récupérer les joueurs de la partie en cours
        Player[] players = boardGame.getPlayers();
        //modifier le joueur qui s'est déplacé
        players[0] = player;
        //modofier les joueurs de la partie en cours
        boardGame.setPlayers(players);

        return boardGame;
    }

    public static void choiceMovePlayer() {
        boolean finished = false;

        while(!finished){
            System.out.println("Player 1");
            System.out.println("zegzegzerg");
            String input = sc.next();
            switch (input){
                case "z" -> {

                }
                case "s" -> {

                }
                case "q" -> {

                }
                case "d" -> {

                }
            }

        }
    }
}
