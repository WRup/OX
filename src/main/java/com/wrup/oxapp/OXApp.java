package com.wrup.oxapp;

import java.util.Scanner;

/**
 * @author Wiktor Rup
 */
public class OXApp {

    public static void main(String[] args) {
        //TODO: what is going on with this scanner? Everyone loves him or what? :p
        GameInitializer gameInitializer = new GameInitializer(new Scanner(System.in));
        Settings settings =  gameInitializer.initializeGame(new Settings());
        new Game(settings).startGame(gameInitializer.getScanner());
    }
}
