package com.company;

import com.sun.tools.jconsole.JConsoleContext;

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

        ClearConsole.clearConsole();

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
                    System.out.println("You quit the game.");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice, please enter it again.");
            }
        }
    }

    /**
     * Function to display the rules.
     */
    public void menuRules() {

        ClearConsole.clearConsole();
        
        boolean finished = false;

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

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                System.out.println("Wrong choice, please enter it again.");
            }
        }
    }

    /**
     * Function that allows you to play the game.
     */
    public void menuGame() {

        ClearConsole.clearConsole();

        boolean finished = false;

        System.out.println("============================");
        System.out.println("|           GAME           |");
        System.out.println("============================");

        System.out.println("Type 'E' to exit the game.");

        System.out.println("Joueur 1 : Quel est votre pseudo ?");
        String inputPlayer1 = sc.next();
        System.out.println("Joueur 2 : Quel est votre pseudo ?");
        String inputPlayer2 = sc.next();

        String [][] tab = new String[11][12];
        // Création du plateau
        BoardGame boardGame = new BoardGame(tab);

        //créer joueurs
        Player player1 = new Player(inputPlayer1, 5, 5);
        Player player2 = new Player(inputPlayer2, 5, 6);

        //récupérer les joueurs de la partie en cours
        Player[] players = boardGame.getPlayers();

        //ajouter dans mon tableau temporaire les joueurs que j'ai crée
        players[0] = player1;
        players[1] = player2;

        //modifie les joueurs de la partie en cours
        boardGame.setPlayers(players);

        //modifie la matrice de la partie en cours
        //boardGame.setBoardGame(boardGame);

        Game.movePlayer(boardGame, player1, 5, 5);


        while (!finished) {
            Display.displayBoard(boardGame.getBoardGame());
            Display.setupPlayer(boardGame.getBoardGame(), player1);

            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                System.out.println("Wrong choice, please enter it again.");
            }
        }

        // Sans doute ici qu'on va appeller la class Player, Display et Game.
    }

    /**
     * Function to display the scores.
     */
    public void menuScoreboard() {

        ClearConsole.clearConsole();

        boolean finished = false;

        System.out.println("============================");
        System.out.println("|       SCORE BOARD        |");
        System.out.println("============================");
        System.out.println("| Highest scores :         |");
        System.out.println("|                          |");
        System.out.println("============================\n");
        System.out.println("Type 'E' to exit the scoreboard.");

        while (!finished) {
            String input = sc.next();

            if ("E".equals(input)) {
                finished = true;
                mainMenu();
            } else {
                System.out.println("Wrong choice, please enter it again.");
            }
        }
    }

    // Ici va falloir appeller la class Score.
}

