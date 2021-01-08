package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class "Game" where the logic of the game can be found.
 */
public class Game {

    public static Scanner sc = new Scanner(System.in);
    public static BoardGame boardGame = new BoardGame();
    public static Player[] players;
    public static final int UP_LIMIT = 0;
    public static final int DOWN_LIMIT = 9;
    public static final int LEFT_LIMIT = 0;
    public static final int RIGHT_LIMIT = 10;

    public Game(Player[] players) {
        this.players = players;
    }

    /**
     * Function that starts the game
     */
    public void play() {
        Player player1 = players[0];
        Player player2 = players[1];
        boolean isRunning = true;

        //It is the player who plays
        Player playerIn;
        Player playerOut;
        Random random = new Random();
        int randomTemp = random.nextInt(10);
        if (randomTemp % 2 == 0) {
            playerIn = player1;
            playerOut = player2;
        } else {
            playerIn = player2;
            playerOut = player1;
        }

        while (isRunning) {
            //Is the last playerIn block himself
            if(!canPlayerMove(playerIn, playerOut)){
                boardGame.displayBoardGame(player1, player2);
                isRunning = false;
                System.out.println(playerOut.pseudo + " loose ! You just got stuck ! \uD83D\uDC4E\uD83C\uDFFC");
                Menu.setColor("MAGENTA", "Type 'E' to exit the game.", true);
                break;
            }
            System.out.println("\nNow it's the turn of " + playerIn.pseudo + " " + playerIn.getRender() + " :");
            //Display boardGame with the players
            boardGame.displayBoardGame(player1, player2);
            //While a player doesn't move
            while (!choiceMovePlayer(playerIn, playerOut)) ;

            boardGame.displayBoardGame(player1, player2);
            //While a player doesn't choose a case to eat
            while (!eatCaseChoice(playerIn, playerOut)) ;

            //If player move ?
            isRunning = canPlayerMove(playerIn, playerOut);
            if (isRunning) {
                //If it is player 1's turn to play, it is to the following to play
                if (playerIn == player1) {
                    playerIn = player2;
                    playerOut = player1;
                } else {
                    playerIn = player1;
                    playerOut = player2;
                }
            } else {
                boardGame.displayBoardGame(player1, player2);
                System.out.println(playerIn.pseudo + " win ! I knew it, you're the best player ! \uD83C\uDFC6");
                Menu.setColor("MAGENTA", "Type 'E' to exit the game.", true);
            }
        }
    }

    /**
     * Function that allows the player to move around the game board
     */
    private boolean choiceMovePlayer(Player playerIn, Player playerOut) {
        boolean played = true;
        int nextPositionX = 0;
        int nextPositionY = 0;
        System.out.println("Where do you want to go? \n" +
                "- Z: up \n" +
                "- S: down\n" +
                "- Q: on the left \n" +
                "- D: right");

        //Depending on the user's input we will have a different event
        switch (sc.next().toLowerCase()) {

            //When "Z" is pressed, the player moves upwards
            case "z" -> {
                nextPositionX = playerIn.getPositionX() - 1;
                nextPositionY = playerIn.getPositionY();
                //If the player reaches the board limit, an error message is displayed.
                if (nextPositionX < UP_LIMIT) {
                    System.out.println("You can't go that way, you'll leave the game board ...");
                    played = false;
                }
            }

            //When S is pressed, the player moves downwards
            case "s" -> {
                nextPositionX = playerIn.getPositionX() + 1;
                nextPositionY = playerIn.getPositionY();
                //If the player reaches the board limit, an error message is displayed.
                if (nextPositionX > DOWN_LIMIT) {
                    System.out.println("You can't go that way, you'll leave the game board ...");
                    played = false;
                }
            }

            //When Q is pressed, the player moves to the left
            case "q" -> {
                nextPositionX = playerIn.getPositionX();
                nextPositionY = playerIn.getPositionY() - 1;
                //If the player reaches the board limit, an error message is displayed.
                if (nextPositionY < LEFT_LIMIT) {
                    System.out.println("You can't go that way, you'll leave the game board ...");
                    played = false;
                }
            }

            //When D is pressed, the player moves to the right
            case "d" -> {
                nextPositionX = playerIn.getPositionX();
                nextPositionY = playerIn.getPositionY() + 1;
                //If the player reaches the board limit, an error message is displayed.
                if (nextPositionY > RIGHT_LIMIT) {
                    System.out.println("You can't go that way, you'll leave the game board ...");
                    played = false;
                }
            }
            default -> {
                System.out.println("Wrong choice, please enter it again.");
                played = false;
            }
        }
        //If the player can move
        if (played) {
            //if the case is not available
            if (!boardGame.isCaseIsAvailable(nextPositionX, nextPositionY, playerIn, playerOut)) {
                played = false;
                System.out.println("You can't go here !");
            } else {
                playerIn.setPositionX(nextPositionX);
                playerIn.setPositionY(nextPositionY);
            }
        }
        return played;
    }

    /**
     * Function who eat the case selected
     * @param playerIn
     * @param playerOut
     * @return
     */
    private boolean eatCaseChoice(Player playerIn, Player playerOut) {
        System.out.println("Enter a case to eat (MIAAAAM) :");
        int selectedCol;
        //Choose a column while selected row is not between 0 and 10
        do {
            System.out.println("Choose a column :");
            //Convert letter in number
            selectedCol = convertLetterToNumber(sc.next().toUpperCase());
        } while (selectedCol == -1);
        int selectedRow;
        //Choose row
        do {
            System.out.println("Choose a row :");
            try {
                Scanner scannerTp = new Scanner(System.in);
                selectedRow = scannerTp.nextInt();
            } catch (InputMismatchException e) {
                selectedRow = -1;
            }
        } while (0 > selectedRow || selectedRow > 10);
        //If case is not available
        if (!boardGame.isCaseIsAvailable(selectedRow - 1, selectedCol, playerIn, playerOut)) {
            System.out.println("You can not eat this case !");
            return false;
        }
        //Eat a case
        boardGame.setCaseIsEaten(selectedRow - 1, selectedCol);
        return true;
    }

    /**
     * Function who say if player can move
     * @param playerIn
     * @param playerOut
     * @return
     */
    private boolean canPlayerMove(Player playerIn, Player playerOut) {

        int posX = playerOut.getPositionX();
        int posY = playerOut.getPositionY();
        //Return true if player can move
        return
                boardGame.isCaseIsAvailable(posX, posY - 1, playerIn, playerOut) ||
                boardGame.isCaseIsAvailable(posX, posY + 1, playerIn, playerOut) ||
                boardGame.isCaseIsAvailable(posX - 1, posY, playerIn, playerOut) ||
                boardGame.isCaseIsAvailable(posX + 1, posY, playerIn, playerOut);
    }

    /**
     * Function who convert letter into number
     * @param letter
     * @return
     */
    private int convertLetterToNumber(String letter) {
        switch (letter) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            case "I":
                return 8;
            case "J":
                return 9;
            case "K":
                return 10;
            default:
                return -1;
        }
    }
}
