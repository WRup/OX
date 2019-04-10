package com.wrup.oxapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * @author Wiktor Rup
 */
public class TestMain {
    public static void main(String[] args) throws FileNotFoundException {

        //TODO: not used
        PrintStream toFile = new PrintStream(new File("./out.txt"));
        PrintStream console = System.out;
        System.setOut(console);

        //TODO: I want to decide it by myself! :D
        int rows = 5;
        int columns = 6;
        int winStreak = 3;
        StringBuilder builder = new StringBuilder();
        //TODO: what are we building here?
        builder.append("1\n1\n").append(rows).append("\n").append(columns).append("\n").append(winStreak).append("\n");

        WinningConditionsGenerator generator = new WinningConditionsGenerator();

        generator.fillMaps(rows,columns);
        //TODO: and who will be a big "winnenn"? :p
        List<String> winnninnCondition = generator.autoWinVerticalGenerator(rows,columns,winStreak);
        for (String str : winnninnCondition) {
            builder.append(str);
        }
        GameInitializer gameInitializer = new GameInitializer(new Scanner(builder.toString()));
        Settings settings =  gameInitializer.initializeGame(new Settings());
        new Game(settings).startGame(gameInitializer.getScanner());
    }
}
