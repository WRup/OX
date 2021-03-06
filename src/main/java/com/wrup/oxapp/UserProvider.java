package com.wrup.oxapp;

import java.util.List;

/**
 * @author Wiktor Rup
 */
class UserProvider {


    User startingUser(List<User> users) {
        User startUser = new User(Sign.X, true);
        for (User user : users) {
            if (user.isFirst()) {
                startUser = user;
                users.set(users.indexOf(user), user.changePriority());
            } else
                users.set(users.indexOf(user), user.changePriority());
        }
        return startUser;
    }


}
