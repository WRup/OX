package com.wrup.oxapp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wiktor Rup
 */
@Test
public class UserSettingsTestClass {

    //TODO: that is all possible settings? are you sure? maybe little bet on beer? :D
    @DataProvider
    public static Object[][] possibleUsersSettings() {
        return new Object[][]{
                {2, true, Sign.X, false, Sign.O},
                {1, true, Sign.O, false, Sign.X}
        };
    }


    @Test(dataProvider = "possibleUsersSettings")
    public void checkSettingsCreation(int whoStarts, boolean isFirst, Sign firstSign, boolean secondOne, Sign singForSecond) {
        UserSettings userSettings = new UserSettings(whoStarts);
        UserGenerator userGenerator = new UserGenerator(userSettings);
        User user1 = new User(firstSign, isFirst);
        User user2 = new User(singForSecond, secondOne);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        assert userList.equals(userGenerator.generateUsers());
    }
}
