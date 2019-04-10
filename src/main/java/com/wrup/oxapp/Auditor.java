package com.wrup.oxapp;

import java.util.List;

/**
 * @author Wiktor Rup
 */
class Auditor {

    //TODO: maybe players will be better name
    //TODO: maybe new object as Users with List (add users in constructor)
    private List<User> users;
    //TODO: who is user here? is he a winner?
    private User user;

    Auditor(List<User> users) {
        this.users = users;
    }

    void addWinScore(User user) {
        this.user = user;
        user.addScore(3);
    }

    void addDrawScore() {
        for (User user : users) {
            user.addScore(1);
        }
    }

    //TODO: why winning() is differ only by user.toString() from result()
    String[] winning() {
        return new String[]{
                user.toString(),
                users.get(0).toString(),
                String.valueOf(users.get(0).getScore()),
                users.get(1).toString(),
                String.valueOf(users.get(1).getScore())
        };
    }

    String[] results() {
        return new String[]{
                users.get(0).toString(),
                String.valueOf(users.get(0).getScore()),
                users.get(1).toString(),
                String.valueOf(users.get(1).getScore())
        };
    }

}
