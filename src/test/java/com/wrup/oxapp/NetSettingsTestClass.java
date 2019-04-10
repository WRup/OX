package com.wrup.oxapp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Wiktor Rup
 */

@Test
public class NetSettingsTestClass {

    //TODO: random, random, use random!!
    @DataProvider
    public static Object[][] checkNetRowsAndColumns(){
        return new Object[][]{
                { 1, 1},
                { 2, 2},
                { 3, 3},
                { 4, 9},
                {12,55},
                {342,23},
                {222,44},
                {123,22},
                {1, 100},
        };
    }

    @Test(dataProvider = "checkNetRowsAndColumns")
    public void testIfSettingsCreatesProperNetGenerator(int row, int column){
        NetSettings netSettings = new NetSettings(row, column);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        assert net.getNetSize() == row*column;
    }

    //TODO: give me more possible cases please :D
    @Test
    public void checkIfPassedRowParameterEqualsProperOne(){
        NetSettings netSettings = new NetSettings(1, 2);
        assert netSettings.getRow() == 1;
    }

    @Test
    public void checkIFPassedColumnParameterEqualsProperOne(){
        NetSettings netSettings = new NetSettings(3, 4);
        assert netSettings.getColumn() == 4;
    }



}
