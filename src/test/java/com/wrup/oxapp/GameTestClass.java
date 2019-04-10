package com.wrup.oxapp;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Wiktor Rup
 */

//TODO: you test here Game class, GameInitializer or both?
@Test
public class GameTestClass {


    @Test
    public void checkGameInitialize() throws IOException {
        String testFile = readFile("drawTest", StandardCharsets.UTF_8);
        GameInitializer gameInitializer = new GameInitializer(new Scanner(testFile));
        Settings settings = gameInitializer.initializeGame(new Settings());
        Game game = new Game(settings);
        game.startGame(gameInitializer.getScanner());
    }


    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
