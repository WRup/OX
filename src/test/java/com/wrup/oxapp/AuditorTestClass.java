package com.wrup.oxapp;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wiktor Rup
 */
@Test
public class AuditorTestClass {

    @Test
    public void checkIfAuditorAddDrawPoints() {
        //TODO: I could set both players to start game and what..? :(
        User user1 = new User(Sign.X, true);
        User user2 = new User(Sign.O, true);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        /* TODO: something like that -->
        Users users = new Users(new User(...), new User(...));
        Auditor auditor = new Auditor(users);
         */

        Auditor auditor = new Auditor(userList);
        auditor.addDrawScore();

        //TODO: where is comment when test failed?
        assert user1.getScore() == 1;
        assert user2.getScore() == 1;
    }

    @Test
    public void checkIfAuditorAddWinnerPoints() {
        User user1 = new User(Sign.X, true);
        User user2 = new User(Sign.O, false);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Auditor auditor = new Auditor(userList);
        auditor.addWinScore(user1);
        assert user1.getScore() == 3;
    }

    @Test
    public void checkIfAuditorKeepsWinningConditions() {
        User user1 = new User(Sign.X, true);
        User user2 = new User(Sign.O, false);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Auditor auditor = new Auditor(userList);
        auditor.addWinScore(user1);

        String[] winningArray = new String[]{
                user1.toString(),
                userList.get(0).toString(),
                String.valueOf(userList.get(0).getScore()),
                userList.get(1).toString(),
                String.valueOf(userList.get(1).getScore())
        };

        assert Arrays.equals(auditor.winning(), winningArray);
    }

    @Test
    public void checkIfAuditorKeepsDrawConditions() {
        User user1 = new User(Sign.X, true);
        User user2 = new User(Sign.O, false);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Auditor auditor = new Auditor(userList);
        auditor.addDrawScore();

        String[] drawArray = new String[]{
                userList.get(0).toString(),
                String.valueOf(userList.get(0).getScore()),
                userList.get(1).toString(),
                String.valueOf(userList.get(1).getScore())
        };

        assert Arrays.equals(auditor.results(), drawArray);
    }
}
