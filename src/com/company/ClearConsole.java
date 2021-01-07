package com.company;

import java.io.IOException;

public class ClearConsole {
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
