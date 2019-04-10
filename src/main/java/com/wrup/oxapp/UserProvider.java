package com.wrup.oxapp;

import java.util.List;

/**
 * @author Wiktor Rup
 */
class UserProvider {

    //private User user;

    User startingUser(List<User> users) {
        //TODO: if I was like Wojtech, I'll set both users to false in 'isFirst', and despite that X would always starts
        // so maybe global field
        User startUser = new User(Sign.X, true);
        for (User user : users) {
            if (user.isFirst()) {
                //this.user = user;
                startUser = user;
                users.set(users.indexOf(user), user.changePriority());
            } else
                users.set(users.indexOf(user), user.changePriority());
        }
        return startUser;
    }


}
