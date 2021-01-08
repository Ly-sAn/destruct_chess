package com.company;

import java.io.IOException;
import java.util.Scanner;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;




public class Menu {

    Scanner sc = new Scanner(System.in);


    /**
     * Function to display the main menu and select an option from this menu.
     */
    public void mainMenu() {

        System.out.println( ansi().eraseScreen().fg(BLUE).a("Hello").fg(GREEN).a(" World").reset() );

        clearConsole();

        boolean finished = false;

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|     ").reset() );
        System.out.print( ansi().eraseScreen().fg(BLUE).a("DESTRUCT CHEESE").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("      |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|     ").reset() );
        System.out.print( ansi().eraseScreen().fg(WHITE).a("Options:").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("             |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|     ").reset() );
        System.out.print( ansi().eraseScreen().fg(GREEN).a("1. Game Rules").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("        |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|     ").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("2. Play").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("              |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|     ").reset() );
        System.out.print( ansi().eraseScreen().fg(BLACK).a("3. Scoreboard").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("        |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|     ").reset() );
        System.out.print( ansi().eraseScreen().fg(MAGENTA).a("4. Exit").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("              |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================").reset() );

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
                    System.out.println( ansi().eraseScreen().fg(MAGENTA).a("You quit the game.").reset() );
                    System.exit(0);
                }
                default -> System.out.println( ansi().eraseScreen().fg(RED).a("Wrong choice, please enter it again.").reset() );
            }
        }
    }

    /**
     * Function to display the rules.
     */
    public void menuRules() {

        clearConsole();
        boolean finished = false;

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("================================================================================").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|                                ").reset() );
        System.out.print( ansi().eraseScreen().fg(GREEN).a("GAME RULES").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                                    |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("================================================================================").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|                           ").reset() );
        System.out.print( ansi().eraseScreen().fg(BLUE).a("The aim of the game ?").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                              |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("| ").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("To destroy as many squares on the board as possible without getting trapped.").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a(" |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("|                                                                              |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|                           ").reset() );
        System.out.print( ansi().eraseScreen().fg(BLUE).a("What are the rules ?").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                               |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("| ").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("During his turn, a player can :").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                                              |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("| ").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("- move his pawn one square (vertically or horizontally)").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                      |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("| ").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("- then he destroys one square on the board.").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                                  |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("|                                                                              |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|                           ").reset() );
        System.out.print( ansi().eraseScreen().fg(BLUE).a("How do I win ?").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                                     |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("| ").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("The last player who can still move wins.").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("                                     |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("================================================================================\n").reset() );


        System.out.println( ansi().eraseScreen().fg(MAGENTA).a("Type 'E' to exit the game.").reset() );

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                System.out.println( ansi().eraseScreen().fg(RED).a("Wrong choice, please enter it again.").reset() );
            }
        }
    }

    /**
     * Function that allows you to play the game.
     */
    public void menuGame() {

        clearConsole();

        boolean finished = false;

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|           ").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("GAME").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("           |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================").reset() );

        System.out.println( ansi().eraseScreen().fg(MAGENTA).a("Type 'E' to exit the game.").reset() );

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                System.out.println( ansi().eraseScreen().fg(RED).a("Wrong choice, please enter it again.").reset() );
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

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|       ").reset() );
        System.out.print( ansi().eraseScreen().fg(BLACK).a("SCORE BOARD").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("        |").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("| ").reset() );
        System.out.print( ansi().eraseScreen().fg(GREEN).a("Highest scores :").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("         |").reset() );

        System.out.print( ansi().eraseScreen().fg(YELLOW).a("|").reset() );
        System.out.print( ansi().eraseScreen().fg(CYAN).a("                          ").reset() );
        System.out.println( ansi().eraseScreen().fg(YELLOW).a("|").reset() );

        System.out.println( ansi().eraseScreen().fg(YELLOW).a("============================\n").reset() );

        System.out.println( ansi().eraseScreen().fg(MAGENTA).a("Type 'E' to exit the scoreboard.").reset() );

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                System.out.println( ansi().eraseScreen().fg(RED).a("Wrong choice, please enter it again.").reset() );
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

