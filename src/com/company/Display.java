package com.company;

public class Display {
        public static void generateBoard() {


            int row,col;
            String[] tableLetter = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "J", "J", "J", "J", "J", "J"};
            String[][] boardGame = new String[10 + 1][11 + 1];
            for(row=0; row<boardGame.length;row++){
                for(col=0; col<boardGame[row].length;col++){
                    if(row==0) {
                        boardGame[row][col] = (String) (" " + tableLetter[col]);
                    } else if(col==0)
                        if (row == 10) {
                            boardGame[row][col]=(String)("10");
                        } else {
                            boardGame[row][col]=(String)(" "+ row);
                        }


                    else boardGame[row][col]=" *";
                }}

            for(row=0; row<boardGame.length;row++){
                System.out.println();
                for(col=0; col<boardGame[row].length;col++){
                    System.out.print(boardGame[row][col]);
                }}
        }

    public static int randomX(int max) {
        int range = max;
        int coordMarmotteX = 0;
        for (int x = 0; x < max; x++) { coordMarmotteX = (int) (Math.random() * range); }
        return coordMarmotteX;
    }
    public static int randomY( int max) {
        int range = max;
        int coordMarmotteY = 0;
        for (int y = 0; y < max; y++) {coordMarmotteY = (int) (Math.random() * range);}
        return coordMarmotteY;
    }

}
