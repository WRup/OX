package com.wrup.oxapp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author Wiktor Rup
 */
@Test
public class MoveMakerTestClass {

    //TODO: why 5x5 is so great you use it in each test?
    @DataProvider
    public static Object[][] checkInitialFieldsIn5x5Net(){
        int counter = 0;
        Object[][] objects = new Object[25][2];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                objects[counter][0]=i;
                objects[counter][1]=j;
                counter++;
            }
        return objects;
    }

    @DataProvider
    public static Object[][] wrongCoordinatesFor5x5Net(){
        Object[][] objects = new Object[300][2];
        for(int i=0;i<300;i++){
            objects[i][0] = new Random().nextInt(1006)+5;
            objects[i][1] = new Random().nextInt(1006)+5;
        }
        return objects;
    }

    @Test(dataProvider = "checkInitialFieldsIn5x5Net")
    public void checkIfMoveIsPossible(int row, int column){
        NetSettings netSettings = new NetSettings(5, 5);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        FieldChecker fieldChecker = new FieldChecker(row, column, net);
        assert fieldChecker.checkField();
    }

    @Test(dataProvider = "wrongCoordinatesFor5x5Net")
    public void checkIfMoveIsImpossibleWhenWrongCoordinates(int row, int column){
        NetSettings netSettings = new NetSettings(5, 5);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        FieldChecker fieldChecker = new FieldChecker(row, column, net);
        assert !fieldChecker.checkField();
    }

    @Test(dataProvider = "checkInitialFieldsIn5x5Net")
    public void checkIfXHasBeenPut(int row, int column){
        NetSettings netSettings = new NetSettings(5, 5);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        MoveMaker moveMaker = new MoveMaker(Sign.O, row,column,net);
        moveMaker.putSign();
        assert net.getField(row,column).getFieldSign().equals(moveMaker.getSignToPut());
    }

    @Test(dataProvider = "checkInitialFieldsIn5x5Net")
    public void checkIfOHasBeenPut(int row, int column){
        NetSettings netSettings = new NetSettings(5, 5);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        MoveMaker moveMaker = new MoveMaker(Sign.X, row,column,net);
        moveMaker.putSign();
        assert net.getField(row,column).getFieldSign().equals(moveMaker.getSignToPut());
    }



}
