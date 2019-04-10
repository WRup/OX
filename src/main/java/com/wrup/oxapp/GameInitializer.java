package com.wrup.oxapp;

import java.util.Scanner;

/**
 * @author Wiktor Rup
 */
class GameInitializer {

    private Scanner scanner;

    GameInitializer(Scanner scanner) {
        this.scanner = scanner;
    }

    Settings initializeGame(Settings settings) {
        Output output = new Output(scanner);
        Input input = new Input();
        String language = output.chooseLanguage();
        //TODO: code duplication, not nice :(
        //----->
        while (!input.checkIfChosenLanguageIsProper(language)) {
            output.wrongLanguage();
            language = output.chooseLanguage();
        }
        settings.setBundleProvider(new StringConverter(language).parseToInt());
        output.printQuitMessage(settings.getBundleProvider());
        //<-----
        //----->
        String whoStarts = output.chooseWhoStarts(settings.getBundleProvider());
        while (!input.checkIfValueChoosePlayer(whoStarts)) {
            output.wrongInput(settings.getBundleProvider());
            whoStarts = output.chooseWhoStarts(settings.getBundleProvider());
        }
        //<-----
        //----->
        String heightOfNet = output.setHeightOfNet(settings.getBundleProvider());
        while (!input.checkIfNetHeightIsProper(heightOfNet)) {
            output.wrongInput(settings.getBundleProvider());
            heightOfNet = output.setHeightOfNet(settings.getBundleProvider());
        }
        //<-----
        //----->
        String widthOfNet = output.setWidthOfNet(settings.getBundleProvider());
        while (!input.checkIfNetWidthIsProper(widthOfNet)) {
            output.wrongInput(settings.getBundleProvider());
            widthOfNet = output.setWidthOfNet(settings.getBundleProvider());
        }
        //<-----
        //----->
        String winStreak = output.setWinStreak(settings.getBundleProvider());
        while (!input.checkIfWinStreakIsProper(winStreak)) {
            output.wrongInput(settings.getBundleProvider());
            winStreak = output.setWinStreak(settings.getBundleProvider());
        }
        //<-----
        settings.setStartPlayer(new StringConverter(whoStarts).parseToInt());
        settings.setNetSize(new StringConverter(heightOfNet).parseToInt(),
                            new StringConverter(widthOfNet).parseToInt());
        settings.setWinStreak(new StringConverter(winStreak).parseToInt());

        return settings;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
