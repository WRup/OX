package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */
class UserSettings {

    private Sign startSign;

    UserSettings(int whoStarts) {
        if (whoStarts == 1)
            this.startSign = Sign.O;
        else this.startSign = Sign.X;
    }

    Sign getStartSign() {
        return startSign;
    }
}
