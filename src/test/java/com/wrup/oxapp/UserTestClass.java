package com.wrup.oxapp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Wiktor Rup
 */
@Test
public class UserTestClass {

    //TODO: you know that user can be empty?
        @DataProvider
    public static Object[][] checkSign(){
        return new Object[][]{
            {Sign.X},
            {Sign.O}
            //{Sign.EMPTY)
        };
    }

    @Test(dataProvider = "checkSign")
    public void checkUserSign(Sign sign) {
        User user = new User(sign, true);

        assert user.getSign().equals(sign);
    }

    @DataProvider
    public static Object[][] userScoreAddition(){

        Object[][] objects = new Object[28][3];
        int counter2 = 0;
        for(int i = 0; i<7; i++){
            for(int j=0; j<4; j++){
                objects[counter2][0]=i;
                //TODO: very clever, but we should adding only 3 or 1 points
                objects[counter2][1]=j;
                objects[counter2][2]=i+j;
                counter2++;
            }

        }
        return objects;
    }

    @Test(dataProvider = "userScoreAddition")
    public void checkUserScoreAddition(int initialScore, int scoreToAdd, int finalScore){
        User user = new User( Sign.X, true);
        user.addScore(initialScore);
        user.addScore(scoreToAdd);

        assert user.getScore() == finalScore;
    }

    @Test
    public void checkIfUserStarts(){
        User user = new User(Sign.X,true);
        assert user.isFirst();
    }

    @Test
    public void checkIfUserDoesNotStart(){
            User user = new User(Sign.O, false);
            assert !user.isFirst();
    }

    @Test
    public void checkIfCompareUsersWorksProperly(){
        User user1 = new User(Sign.O, false);
        User user2 = new User(Sign.X, true);
        user1.addScore(3);
        //TODO: I don't know how you compare --> put comparator in method comparePoints()
        assert user1.compareTo(user2) > 0;
    }

    @Test
    public void checkIfUserAreEqual(){
        User user = new User(Sign.X, false);
        User user1 = new User(Sign.X, false);
        assert user.equals(user1);
    }

    @Test
    public void checkIfPriorityIsChanged(){
        User user = new User(Sign.O, true);
        user.changePriority();
        assert user.equals(new User(Sign.O,false));
    }

}
