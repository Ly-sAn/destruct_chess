package com.company;

/**
 * Class "BoardGame" which defines a game board (table), represented by rows and columns.
 */
public class BoardGame {

    public static int row, col;
    private String[][] boardGame;

    /**
     * Creating a function to display the game board
     * @param joueur1
     * @param joueur2
     * @return the game board
     */
    public String[][] BoardGame(Player joueur1, Player joueur2) {

        //Table initialisation: 11 by 12
        boardGame = new String[11][12];

        //Initialisation of a letter table
        String[] tableLetter = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

        //For each line
        for (row = 0; row < boardGame.length; row++) {
            //For each column
            for (col = 0; col < boardGame[row].length; col++) {
                //If the line = 0, I call up my letter table
                if (row == 0) {
                    boardGame[row][col] = (" " + tableLetter[col]);
                }
                //Else if the column = 0 ...
                else if (col == 0)
                    //If the lines = 10, I display "10"
                    if (row == 10) {
                        boardGame[row][col] = ("10");
                    }
                    //Else I display spaces
                    else {
                        boardGame[row][col] = (" " + row);
                    }
                //Else I fill in my chart with "*"
                else
                    boardGame[row][col] = " *";
            }
        }

        //Call setUpPlayer function
        setUpPlayer(boardGame, joueur1, joueur2);

        //Display each row and column of the game board
        for (row = 0; row < boardGame.length; row++) {
            System.out.println();
            for (col = 0; col < boardGame[row].length; col++) {
                System.out.print(boardGame[row][col]);
            }
        }
        return boardGame;
    }

    /**
     * Creation of a function to put the players in the game board
     * @param boardGame
     * @param joueur1
     * @param joueur2
     */
    public static void setUpPlayer(String[][] boardGame, Player joueur1, Player joueur2) {

        //Depending on its position on the tray :
        //player 1 will be represented by an O
        boardGame[joueur1.positionX][joueur1.positionY] = " O";

        //player 2 will be represented by a P
        boardGame[joueur2.positionX][joueur2.positionY] = " P";
    }
}
