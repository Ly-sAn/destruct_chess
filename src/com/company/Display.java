package com.company;

public class Display {

    public static int row, col;

    public static String[][] displayBoard(String[][] matrice, Player joueur1, Player joueur2) {

        String[] tableLetter = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M"};
        //int playerX = 5;
        //int playerY = 5;
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

        //matrice[playerX][playerY] = " O";
       // matrice[playerX][playerY + 1] = " P";
        setUpPlayer(matrice, joueur1, joueur2);

        for (row = 0; row < matrice.length; row++) {
            System.out.println();
            for (col = 0; col < matrice[row].length; col++) {
                System.out.print(matrice[row][col]);
            }
        }

        return matrice;
    }

    public static void setUpPlayer(String[][] boardGame, Player joueur1, Player joueur2) {
      // int playerX = 5;
      // int playerY = 5;
       boardGame[joueur1.positionX][joueur1.positionY] = " O";
       boardGame[joueur2.positionX][joueur2.positionY] = " P";
       //boardGame[playerX][playerY + 1] = " P";
    }
}

