package com.wrup.oxapp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Wiktor Rup
 */
@Test
public class InputValidatorTestClass {

    //TODO: where do I use that?
    @DataProvider
    public static Object[][] negativeNumbersForInputTest() {
        Random random = new Random();
        Object[][] objects = new Object[10][1];
        for (int i = 0; i < objects.length; i++) {
            objects[i][0] = random.nextInt(1000) - 1000;
        }
        return objects;
    }

    @DataProvider
    public static Object[][] properSizeOfNet() {
        Object[][] objects = new Object[98][1];
        int counter = 0;
        for (int i = 3; i < 101; i++) {
            objects[counter][0] = String.valueOf(i);
            counter++;
        }
        return objects;
    }

    @Test(dataProvider = "properSizeOfNet")
    public void checkIfGivenNumberIsBetween3And100(String sizeOfNet) {
        Input inputValidator = new Input();
        assert inputValidator.checkIfNetWidthIsProper(sizeOfNet);
    }

    //TODO: hahaha, I want to check 69 number :p
    @Test
    public void checkIfGivenNumberIs1Or2() {
        Input inputValidator = new Input();
        assert inputValidator.checkIfValueChoosePlayer("2");
        assert !inputValidator.checkIfValueChoosePlayer("123");
    }

    @Test
    public void checkIfGivenNumberIsBiggerThan3() {
        Input inputValidator = new Input();
        inputValidator.checkIfNetWidthIsProper("10");
        inputValidator.checkIfNetHeightIsProper("10");
        assert inputValidator.checkIfWinStreakIsProper("4");
    }

}
