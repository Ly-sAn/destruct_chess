package com.company;

public class Display {

    public static int row, col;

    public static void setupBoard() {
        int row,col;
        String[] tableLetter = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
        String[][] boardGame = new String[10 + 1][11 + 1];
        int playerX = 5;
        int playerY = 5;

        for(row=0; row<boardGame.length;row++){
            for(col=0; col<boardGame[row].length;col++){
                if(row==0) {
                    boardGame[row][col] = (" " + tableLetter[col]);
                } else if(col==0)
                    if (row == 10) {
                        boardGame[row][col]=("10");
                    } else {
                        boardGame[row][col]=(" "+ row);
                    } else
                        boardGame[row][col]=" *";
            }
        }
        boardGame[playerX][playerY] = " O";
        boardGame[playerX][playerY+1] = " P";


        for(row=0; row<boardGame.length;row++){
            System.out.println();
            for(col=0; col<boardGame[row].length;col++){
                System.out.print(boardGame[row][col]);
            }
        }

    }

    private static void setupPlayer(){

    }





}
