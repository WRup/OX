package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */

//TODO: isn't Input == InputValidator? Input class only checks and validate :p
class Input {

    private InputValidator inputValidator = new InputValidator();

    boolean checkIfChosenLanguageIsProper(String language) {
        return inputValidator.checkIfChosenLanguageIsProper(language);
    }

    boolean checkIfNetHeightIsProper(String netHeight) {
        return inputValidator.checkIfNetHeightIsProper(netHeight);
    }

    boolean checkIfNetWidthIsProper(String netWidth) {
        return inputValidator.checkIfNetWidthIsProper(netWidth);
    }

    boolean checkIfValueChoosePlayer(String player) {
        return inputValidator.checkIfValueChoosePlayer(player);
    }

    boolean checkIfWinStreakIsProper(String winStreak) {
        return inputValidator.checkIfWinStreakIsProper(winStreak);

    }

    boolean checkIfUserMoveIsProper(String coordinates, Sign sign, Net net) {
        return inputValidator.checkIfUserMoveIsProper(coordinates, sign, net);
    }

}
