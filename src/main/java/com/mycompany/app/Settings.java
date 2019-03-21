package com.mycompany.app;

import java.util.List;

/**
 * @author Wiktor Rup
 */
class Settings {


    private UserSettings userSettings;
    private NetSettings netSettings;
    private int winStreak;
    private BundleProvider bundleProvider;

    List<User> generateUsers() {
        UserGenerator userGenerator = new UserGenerator(userSettings);
        return userGenerator.generateUsers();
    }

    void setNetSize(int row, int column) {
        netSettings = new NetSettings(row, column);
    }

    Net createNet() {
        NetCreator netCreator = new NetCreator(netSettings);
        return netCreator.createNet();
    }

    int getWinStreak() {
        return winStreak;
    }

    void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    void setStartPlayer(int whoStarts) {
        userSettings = new UserSettings(whoStarts);
    }

    void setBundleProvider(int language) {
        if (language == 1)
            this.bundleProvider = new BundleProvider("pl");
        else
            this.bundleProvider = new BundleProvider("en");
    }

    BundleProvider getBundleProvider() {
        return bundleProvider;
    }
}
