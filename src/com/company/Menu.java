package com.company;

import java.io.IOException;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Menu {

    Scanner sc = new Scanner(System.in);

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

        setColor("BLUE", "HELLOOOOO", true);

        System.out.println( ansi().eraseScreen().fg(BLUE).a("Hello").fg(GREEN).a(" World").reset() );

        clearConsole();

        boolean finished = false;

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

        while (!finished) {
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
                    setColor("MAGENTA", "You quit the game.", true);
                    System.exit(0);
                }
                default -> setColor("RED", "Wrong choice, please enter it again.", true);
            }
        }
    }

    /**
     * Function to display the rules.
     */
    public void menuRules() {

        clearConsole();
        boolean finished = false;

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

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                setColor("RED", "Wrong choice, please enter it again.", true);
            }
        }
    }

    /**
     * Function that allows you to play the game.
     */
    public void menuGame() {

        clearConsole();

        boolean finished = false;

        setColor("YELLOW", "============================", true);

        setColor("YELLOW", "|           ", false);
        setColor("CYAN", "GAME", false);
        setColor("YELLOW", "           |", true);

        setColor("YELLOW", "============================", true);

        setColor("MAGENTA", "Type 'E' to exit the game.", true);

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                setColor("RED", "Wrong choice, please enter it again.", true);
            }
        }

        // Sans doute ici qu'on va appeller la class Player, Display et Game.
    }

    /**
     * Function to display the scores.
     */
    public void menuScoreboard() {

        clearConsole();

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

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                setColor("RED", "Wrong choice, please enter it again.", true);
            }
        }
    }

    // Ici va falloir appeller la class Score.

    public static void clearConsole() {
        if (System.getProperty("os.name").startsWith("Windows")){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}

