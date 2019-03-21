package com.mycompany.app;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wiktor Rup
 */
@Test
public class UserProviderTestClass {


    @Test
    public void checkIfReturnsProperUser(){
        User user1 = new User(Sign.X,true);
        User user2 = new User(Sign.O, false);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        UserProvider userProvider = new UserProvider();
        assert userProvider.startingUser(userList).equals(user1);
    }
}
