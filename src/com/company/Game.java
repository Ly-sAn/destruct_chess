package com.company;

import java.util.Scanner;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * Class "Game" where the logic of the game can be found.
 */
public class Game {

    public static Scanner sc = new Scanner(System.in);
    public static BoardGame boardGame = new BoardGame();
    public static Player[] players;

    public Game(Player[] players) {
        this.players = players;
    }

    /**
     * Function that starts the game
     */
    public void play() {
        Player player1 = players[0];
        Player player2 = players[1];

        //Define the starting position of the players
        player1.setPositionX(5);
        player1.setPositionY(5);
        player2.setPositionX(5);
        player2.setPositionY(6);

        //Allows players to be placed on the game board
        boardGame.BoardGame(player1, player2);

        //Call choiceMovePlayer function
        choiceMovePlayer(player1, player2);

    }
/*
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

 */

    /**
     * Function that allows the player to move around the game board
     * @param player1
     * @param player2
     */
    public static void choiceMovePlayer(Player player1, Player player2) {
        //Declare a boolean "finished" to false ...
        boolean finished = false;

        //Declare a boolean "played" to false ...
        boolean played = false;

        //It is the player who plays
        Player playerIn = player1;

        //... until I have entered a key
        while(!finished){

            System.out.println("\nNow it's the turn of " + playerIn.pseudo + " :");
            System.out.println("Where do you want to go? \n" +
                    "- Z: up \n" +
                    "- S: down\n" +
                    "- Q: on the left \n" +
                    "- D: right");
            String input = sc.next();

            //Depending on the user's input we will have a different event
            switch (input.toLowerCase()){

                //When "Z" is pressed, the player moves upwards
                case "z" -> {
                    //If the player reaches the board limit, an error message is displayed.
                    if (playerIn.getPositionX()-1 == 0) {
                        System.out.println("You can't go that way, you'll leave the game board ...");
                        played = false;
                    } else {
                        playerIn.setPositionX(playerIn.getPositionX() - 1);
                        playerIn.setPositionY(playerIn.getPositionY());
                        changePlayerPosition(playerIn, player1, player2);
                        // ... until he played
                        played = true;
                    }
                }

                //When Z is pressed, the player moves downwards
                case "s" -> {
                    //If the player reaches the board limit, an error message is displayed.
                    if (playerIn.getPositionX()+1 == 11) {
                        System.out.println("You can't go that way, you'll leave the game board ...");
                        played = false;
                    } else {
                        playerIn.setPositionX(playerIn.getPositionX() + 1);
                        playerIn.setPositionY(playerIn.getPositionY());
                        changePlayerPosition(playerIn, player1, player2);
                        played = true;
                    }
                }

                //When Z is pressed, the player moves to the left
                case "q" -> {
                    //If the player reaches the board limit, an error message is displayed.
                    if (playerIn.getPositionY()-1 == 0) {
                        System.out.println("You can't go that way, you'll leave the game board ...");
                        played = false;
                    } else {
                        playerIn.setPositionX(playerIn.getPositionX());
                        playerIn.setPositionY(playerIn.getPositionY() - 1);
                        changePlayerPosition(playerIn, player1, player2);
                        played = true;
                    }
                }

                //When Z is pressed, the player moves to the right
                case "d" -> {
                    //If the player reaches the board limit, an error message is displayed.
                    if (playerIn.getPositionY()+1 == 12) {
                        System.out.println("You can't go that way, you'll leave the game board ...");
                        played = false;
                    } else {
                        playerIn.setPositionX(playerIn.getPositionX());
                        playerIn.setPositionY(playerIn.getPositionY() + 1);
                        changePlayerPosition(playerIn, player1, player2);
                        played = true;
                    }
                }
                default -> System.out.println("Wrong choice, please enter it again.");
            }

            //If the player's turn is over
            if (played){
                //If it is player 1's turn to play, it is to the following to play
                if (playerIn == player1) {
                    playerIn = player2;
                }
                else{
                    playerIn = player1;
                }
            }
        }
    }

    /**
     * Function that allows to change the positions of the player who is playing
     * @param playerIn
     * @param player1
     * @param player2
     */
    public static void changePlayerPosition(Player playerIn, Player player1, Player player2){
        //If it is player 1's turn to play, his positions are changed and vice versa.
        if (playerIn == player1) {
            boardGame.BoardGame(playerIn, player2);
        }
        else{
            boardGame.BoardGame(player1, playerIn);
        }
    }
}
