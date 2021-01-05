package com.company;

import java.util.Scanner;

public class Menu {



    Scanner sc = new Scanner(System.in);

    public void mainMenu(){

        boolean finished = false;


        System.out.println("============================");
        System.out.println("|     DESTRUCT CHEESE      |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|  1. Game Rules           |");
        System.out.println("|  2. Play                 |");
        System.out.println("|  3. Scoreboard           |");
        System.out.println("|  4. Exit                 |");
        System.out.println("============================");


        while (!finished){

            String input = sc.next();

            switch (input) {
                case "1" -> {
                    finished = true;
                    menuRules();
                }
                case "2" -> {
                    finished = true;
                    menuGame();
                }
                case "3" -> {
                    finished = true;
                    menuScoreboard();
                }
                case "4" -> {
                    System.out.println("Vous quittez le programme");
                    System.exit(0);
                }
                default -> System.out.println("Mauvais choix, veuillez le saisir à nouveau");
            }
        }
    }

    public void menuRules() {

        boolean finished = false;

        System.out.println("============================");
        System.out.println("|     DESTRUCT CHEESE      |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|  1. Game Rules           |");
        System.out.println("|  2. Play                 |");
        System.out.println("|  3. Scoreboard           |");
        System.out.println("|  4. Back to Main Menu    |");
        System.out.println("============================");


        while (!finished){
            String input = sc.next();



            switch (input){

                case "4" -> {
                    finished = true;
                    mainMenu();
                }
            }

        }




    }

    public void menuGame(){


    }

    public void menuScoreboard(){

    }


}
