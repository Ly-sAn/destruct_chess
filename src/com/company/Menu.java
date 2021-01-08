package com.company;

import java.util.Scanner;
import static org.fusesource.jansi.Ansi.*;

public class Menu {

    Scanner sc = new Scanner(System.in);

    /**
     * Function to set color to println
     * @param color
     * @param menuString
     * @param println
     */
    public static void setColor(String color, String menuString, boolean println){
        if (println){
            System.out.println( ansi().eraseScreen().fg(Color.valueOf(color)).a(menuString).reset() );
        } else {
            System.out.print( ansi().eraseScreen().fg(Color.valueOf(color)).a(menuString).reset() );
        }
    }

    /**
     * Function to display the main menu and select an option from this menu.
     */
    public void mainMenu() {

        //Clear the console
        ClearConsole.clearConsole();

        //Declare a boolean to false ...
        boolean finished = false;

        //Display the menu
        setColor("YELLOW", "============================", true );
        setColor("YELLOW", "|     ", false);
        setColor("BLUE", "DESTRUCT CHEESE", false);
        setColor("YELLOW", "      |", true);

        setColor("YELLOW", "============================", true);

        setColor("YELLOW", "|     ", false);
        setColor("WHITE", "Options:", false);
        setColor("YELLOW", "             |", true);

        setColor("YELLOW", "|     ", false);
        setColor("GREEN", "1. Game Rules", false);
        setColor("YELLOW", "        |", true);

        setColor("YELLOW", "|     ", false);
        setColor("CYAN", "2. Play", false);
        setColor("YELLOW", "              |", true);

        setColor("YELLOW", "|     ", false);
        setColor("BLACK", "3. Scoreboard", false);
        setColor("YELLOW", "        |", true);

        setColor("YELLOW", "|     ", false);
        setColor("MAGENTA", "4. Exit", false);
        setColor("YELLOW", "              |", true);

        setColor("YELLOW", "============================", true);

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
                    setColor("MAGENTA", "You quit the game.", true);
                    System.exit(0);
                }

                //If the user types anything else, an error message is displayed
                default -> setColor("RED", "Wrong choice, please enter 'E' it again.", true);
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
        setColor("YELLOW", "================================================================================", true);

        setColor("YELLOW", "|                                ", false);
        setColor("GREEN", "GAME RULES", false);
        setColor("YELLOW", "                                    |", true);

        setColor("YELLOW", "================================================================================", true);

        setColor("YELLOW", "|                           ", false);
        setColor("BLUE", "The aim of the game ?", false);
        setColor("YELLOW", "                              |", true);

        setColor("YELLOW", "| ", false);
        setColor("CYAN", "To destroy as many squares on the board as possible without getting trapped.", false);
        setColor("YELLOW", " |", true);

        setColor("YELLOW", "|                                                                              |", true);

        setColor("YELLOW", "|                           ", false);
        setColor("BLUE", "What are the rules ?", false);
        setColor("YELLOW", "                               |", true);

        setColor("YELLOW", "| ", false);
        setColor("CYAN", "During his turn, a player can :", false);
        setColor("YELLOW", "                                              |", true);

        setColor("YELLOW", "| ", false);
        setColor("CYAN", "- move his pawn one square (vertically or horizontally)", false);
        setColor("YELLOW", "                      |", true);

        setColor("YELLOW", "| ", false);
        setColor("CYAN", "- then he destroys one square on the board.", false);
        setColor("YELLOW", "                                  |", true);

        setColor("YELLOW", "|                                                                              |", true);

        setColor("YELLOW", "|                           ", false);
        setColor("BLUE", "How do I win ?", false);
        setColor("YELLOW", "                                     |", true);

        setColor("YELLOW", "| ", false);
        setColor("CYAN", "The last player who can still move wins.", false);
        setColor("YELLOW", "                                     |", true);

        setColor("YELLOW", "================================================================================\n", true);

        setColor("MAGENTA", "Type 'E' to exit the game.", true);

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
                setColor("RED", "Wrong choice, please enter 'E' it again.", true);
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
        setColor("YELLOW", "============================", true);

        setColor("YELLOW", "|           ", false);
        setColor("CYAN", "GAME", false);
        setColor("YELLOW", "           |", true);

        setColor("YELLOW", "============================", true);

        //Initialization of the players' table
        Player[] players = new Player[2];

        //Loop that allows to create two users with their nickname
        for (int idPlayer = 0; idPlayer < 2; idPlayer++) {
            //Creation of a variable to check the size of the user's pseudo
            String pseudo = checkPseudo(idPlayer + 1, players);
            //If the pseudo is identical we start again
            if (idPlayer == 1) {
                if (pseudo.equals(players[idPlayer-1].pseudo)) {
                    System.out.println("This username is already taken, please choose another one !");
                    idPlayer--;
                } else {
                    //Adding the name to the table
                    players[idPlayer] = new Player(pseudo, 5, 4+idPlayer, "\uD83D\uDC2D");
                }
            } else {
                players[idPlayer] = new Player(pseudo, 5, 4+idPlayer, "\ud83d\udc01");
            }
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
                setColor("RED", "Wrong choice, please enter 'E' it again.", true);
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

        setColor("YELLOW", "============================", true);

        setColor("YELLOW", "|       ", false);
        setColor("BLACK", "SCORE BOARD", false);
        setColor("YELLOW", "        |", true);

        setColor("YELLOW", "============================", true);

        setColor("YELLOW", "| ", false);
        setColor("GREEN", "Highest scores :", false);
        setColor("YELLOW", "         |", true);

        setColor("YELLOW", "|", false);
        setColor("CYAN", "                          ", false);
        setColor("YELLOW", "|", true);

        setColor("YELLOW", "============================\n", true);

        setColor("MAGENTA", "Type 'E' to exit the scoreboard.", true);

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
                setColor("RED", "Wrong choice, please enter 'E' it again.", true);
            }
        }
    }
}

