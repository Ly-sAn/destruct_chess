package com.company;

public class Display {

    public static int row, col;

    public static String[][] displayBoard(String[][] matrice) {

        String[] tableLetter = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};

        for (row = 0; row < matrice.length; row++) {
            for (col = 0; col < matrice[row].length; col++) {
                if (row == 0) {
                    matrice[row][col] = (" " + tableLetter[col]);
                } else if (col == 0)
                    if (row == 10) {
                        matrice[row][col] = ("10");
                    } else {
                        matrice[row][col] = (" " + row);
                    }
                else
                    matrice[row][col] = " *";
            }
        }

        for (row = 0; row < matrice.length; row++) {
            System.out.println();
            for (col = 0; col < matrice[row].length; col++) {
                System.out.print(matrice[row][col]);
            }
        }

        return matrice;
    }

    public static void setupPlayer(String[][] boardGame, Player joueur) {
        int playerX = 5;
        int playerY = 5;
        boardGame[playerX][playerY] = " O";
        boardGame[playerX][playerY + 1] = " P";
    }
}

