package com.wrup.oxapp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wiktor Rup
 */
class UserGenerator {

    private UserSettings userSettings;

    UserGenerator(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    List<User> generateUsers() {
        //TODO: you know what I'm think about, yes?
        ArrayList<User> users = new ArrayList<>();
        //TODO: startingUser will be better, what you think?
        User user1 = new User(userSettings.getStartSign(), true);
        users.add(user1);
        //TODO: in enum we can make method which returns opposed sign
        if (userSettings.getStartSign().equals(Sign.X)) {
            User user2 = new User(Sign.O, false);
            users.add(user2);
        } else {
            User user2 = new User(Sign.X, false);
            users.add(user2);
        }
        return users;

    }
}
