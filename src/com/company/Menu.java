package com.company;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;
import static org.fusesource.jansi.Ansi.ansi;

public class Menu {

    Scanner sc = new Scanner(System.in);

    /**
     * Function to display the main menu and select an option from this menu.
     */
    public void mainMenu() {

        //Clear the console
        ClearConsole.clearConsole();

        //Declare a boolean to false ...
        boolean finished = false;

        //Display the menu
        System.out.println("============================");
        System.out.println("|     DESTRUCT CHEESE      |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("|  1. Game Rules           |");
        System.out.println("|  2. Play                 |");
        System.out.println("|  3. Scoreboard           |");
        System.out.println("|  4. Exit                 |");
        System.out.println("============================");

        // ... until I have entered a key
        while (!finished) {

            //Prompts the user to enter a menu item
            System.out.println("Type the number of the option you want to launch !");
            String input = sc.next();

            //Depending on the user's input we will have a different event
            switch (input) {

                //If the user types 1 we will go to the rules of the game
                case "1" -> {
                    finished = true;
                    menuRules();
                }

                //If the user types 2, a game will be started
                case "2" -> {
                    finished = true;
                    menuGame();
                }

                //If the user types 3 we will look at the scoreboard
                case "3" -> {
                    finished = true;
                    menuScoreboard();
                }

                //If the user types 4, the game is quit
                case "4" -> {
                    System.out.println("You quit the game.");
                    System.exit(0);
                }

                //If the user types anything else, an error message is displayed
                default -> System.out.println("Wrong choice, please enter it again.");
            }
        }
    }

    /**
     * Function to display the rules.
     */
    public void menuRules() {

        //Clear the console
        ClearConsole.clearConsole();

        //Declare a boolean to false ...
        boolean finished = false;

        //Display the rules
        System.out.println("================================================================================");
        System.out.println("|                                GAME RULES                                    |");
        System.out.println("================================================================================");
        System.out.println("|                           The aim of the game ?                              |");
        System.out.println("| To destroy as many squares on the board as possible without getting trapped. |\n");
        System.out.println("|                            What are the rules ?                              |");
        System.out.println("| During his turn, a player can :                                              |");
        System.out.println("| - move his pawn one square (vertically or horizontally)                      |");
        System.out.println("| - then he destroys one square on the board.                                  |\n");
        System.out.println("|                                How do I win ?                                |");
        System.out.println("| The last player who can still move wins.                                     |");
        System.out.println("================================================================================\n");
        System.out.println("Type 'E' to exit the game.");

        // ... until I have entered a key
        while (!finished) {

            //Requests the user to enter the letter "E"
            String input = sc.next();

            //If the user types the letter "E" correctly, we return to the game menu.
            if (input.toLowerCase().equals("e")) {
                finished = true;
                mainMenu();
            }

            // Else an error message will be displayed and you will be asked to retype the letter "E".
            else {
                System.out.println("Wrong choice, please enter \"E\" it again.");
            }
        }
    }

    /**
     * Function that allows you to play the game.
     */
    public void menuGame() {

        //Clear the console
        ClearConsole.clearConsole();

        //Declare a boolean to false ...
        boolean finished = false;

        //Display the game
        System.out.println("============================");
        System.out.println("|           GAME           |");
        System.out.println("============================");
        //System.out.println("Type 'E' to exit the game.");

        //Initialization of the players' table
        Player[] players = new Player[2];

        //Loop that allows to create two users with their nickname
        for (int idPlayer = 0; idPlayer < 2; idPlayer++) {
            //Creation of a variable to check the size of the user's pseudo
            String pseudo = checkPseudo(idPlayer + 1, players);
            //Adding the name to the table
            players[idPlayer] = new Player(pseudo, 5, 5+idPlayer, idPlayer==1?"\uD83D\uDC2D":"\ud83d\udc01");
        }

        //Start a new game
        new Game(players).play();

        //... until I have entered a key
        while (!finished) {
            //Requests the user to enter the letter "E"
            String input = sc.next();
            //If the user types the letter "E" correctly, we return to the game menu.
            if ("e".equals(input.toLowerCase())) {
                finished = true;
                mainMenu();
            }
            //Else an error message will be displayed and you will be asked to retype the letter "E".
            else {
                System.out.println("Wrong choice, please enter \"E\" it again.");
            }
        }
    }

    /**
     * Creation of a function to check the size of the pseudo
     * @param idPlayer
     * @param players
     * @return the variable pseudo
     */
    public String checkPseudo(int idPlayer, Player[] players) {

        //Ask the user to enter his pseudo
        System.out.println("Please enter the player's pseudo " + idPlayer);
        String checkPseudo = sc.next();

        //If the pseudo < 2 characters or the pseudo > 10 ...
        if (checkPseudo.length() < 2 || checkPseudo.length() > 10) {
            //Display an error message
            System.out.println("You must enter a pseudo between a minimum of 2 characters and a maximum of 10 characters.");
            //Reminder of the function
            checkPseudo(idPlayer, players);
        }
        //Returns the variable pseudo
        return checkPseudo;
    }

    /**
     * Function to display the scores.
     */
    public void menuScoreboard() {

        //Clear the console
        ClearConsole.clearConsole();

        //Declare a boolean to false ...
        boolean finished = false;

        System.out.println("============================");
        System.out.println("|       SCORE BOARD        |");
        System.out.println("============================");
        System.out.println("| Highest scores :         |");
        System.out.println("|                          |");
        System.out.println("============================\n");
        System.out.println("Type 'E' to exit the scoreboard.");

        //... until I have entered a key
        while (!finished) {

            //Requests the user to enter the letter "E"
            String input = sc.next();

            //If the user types the letter "E" correctly, we return to the game menu.
            if ("e".equals(input.toLowerCase())) {
                finished = true;
                mainMenu();
            }
            //Else an error message will be displayed and you will be asked to retype the letter "E".
            else {
                System.out.println("Wrong choice, please enter it again.");
            }
        }
    }
}

