package com.company;

/**
 * Class "BoardGame" which defines a game board (table), represented by rows and columns.
 */
public class BoardGame {

    private Case[][] boardGame;

    //constructor
    public BoardGame(){
        boardGame = new Case[10][];
        for (int row = 0; row < boardGame.length; row++)
        {
            boardGame[row] = new Case[11];
            for (int column = 0; column < boardGame[row].length; column++)
            {
                boardGame[row][column] = new Case(row, column);
            }
        }
    }

    /**
     * Function who display boarGame with the 2 players
     * @param p1
     * @param p2
     */
    public void displayBoardGame(Player p1, Player p2)
    {
        for (int row = -1; row < boardGame.length; row++)
        {
            if (row == -1)
            {
                for (int column = -1; column < boardGame[0].length; column++)
                {
                    if (column == -1)
                    {
                        System.out.print("  ");
                    }
                    else
                    {
                        System.out.print(" " + GetHeaderFromColumn(column));
                    }
                }
            }
            else
            {
                for (int column = -1; column < boardGame[row].length; column++)
                {
                    if (column == -1)
                    {
                        System.out.print(row == 9 ? row + 1 : " " +(row + 1));
                    }
                    else
                    {
                        if (p1.isOn(row, column))
                        {
                            System.out.print(" " +p1.getRender());
                        }
                        else if (p2.isOn(row, column))
                        {
                            System.out.print(" " +p2.getRender());
                        }
                        else
                        {
                            System.out.print(" " + boardGame[row][column].getRender());
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Function who get the letter to put above boardGame
     * @param column
     * @return
     */
    public String GetHeaderFromColumn(int column)
    {
        switch (column)
        {
            case 0:
                return " A";
            case 1:
                return " B";
            case 2:
                return " C";
            case 3:
                return " D";
            case 4:
                return " E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H ";
            case 8:
                return "I ";
            case 9:
                return "J ";
            case 10:
                return "K ";
            default:
                return "";
        }
    }

    /**
     * Function who set if case is available
     * @param row
     * @param col
     * @param player1
     * @param player2
     * @return
     */
    public boolean isCaseIsAvailable(int row, int col, Player player1, Player player2){
        return !boardGame[row][col].getIsEaten() && !player1.isOn(row, col) && !player2.isOn(row, col) ;
    }

    /**
     * Function who mark the case has eaten
     * @param row
     * @param column
     */
    public void setCaseIsEaten(int row, int column){
        boardGame[row][column].setIsEaten(true);
    }

    /**
     * Function who get if the case is eaten
     * @param row
     * @param column
     * @return
     */
    public boolean getCaseIsEaten(int row, int column){
        return boardGame[row][column].getIsEaten();
    }


}
