package com.wrup.oxapp;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Wiktor Rup
 */

@Test
public class NetTestClass {

    //TODO: do you know random? :p
    @DataProvider
    public static Object[][] netSizesGeneratorWhichAreOk(){
        return new Object[][]{
                {3,3,9},
                {5,5,25},
                {123,834,102582},
                {1,1,1}
        };
    }

    @DataProvider
    public static Object[][] checkInitialFieldsIn5x5Net(){
        return new Object[][]{
                {0,0,Sign.EMPTY},
                {0,1,Sign.EMPTY},
                {0,2,Sign.EMPTY},
                {0,3,Sign.EMPTY},
                {0,4,Sign.EMPTY},
                {1,0,Sign.EMPTY},
                {1,1,Sign.EMPTY},
                {1,2,Sign.EMPTY},
                {1,3,Sign.EMPTY},
                {1,4,Sign.EMPTY},
                {2,0,Sign.EMPTY},
                {2,1,Sign.EMPTY},
                {2,2,Sign.EMPTY},
                {2,3,Sign.EMPTY},
                {2,4,Sign.EMPTY},
                {3,0,Sign.EMPTY},
                {3,1,Sign.EMPTY},
                {3,2,Sign.EMPTY},
                {3,3,Sign.EMPTY},
                {3,4,Sign.EMPTY},
                {4,0,Sign.EMPTY},
                {4,1,Sign.EMPTY},
                {4,2,Sign.EMPTY},
                {4,3,Sign.EMPTY},
                {4,4,Sign.EMPTY},

        };
    }

    @DataProvider
    public static Object[][] checkClearanceFor5x5Net(){
        return new Object[][]{
                {0,0,Sign.X,Sign.EMPTY},
                {0,1,Sign.X,Sign.EMPTY},
                {0,2,Sign.O,Sign.EMPTY},
                {0,3,Sign.EMPTY,Sign.EMPTY},
                {0,4,Sign.X,Sign.EMPTY},
                {1,0,Sign.O,Sign.EMPTY},
                {1,1,Sign.O,Sign.EMPTY},
                {1,2,Sign.X,Sign.EMPTY},
                {1,3,Sign.X,Sign.EMPTY},
                {1,4,Sign.EMPTY,Sign.EMPTY},
                {2,0,Sign.EMPTY,Sign.EMPTY},
                {2,1,Sign.X,Sign.EMPTY},
                {2,2,Sign.O,Sign.EMPTY},
                {2,3,Sign.O,Sign.EMPTY},
                {2,4,Sign.X,Sign.EMPTY},
                {3,0,Sign.X,Sign.EMPTY},
                {3,1,Sign.X,Sign.EMPTY},
                {3,2,Sign.O,Sign.EMPTY},
                {3,3,Sign.O,Sign.EMPTY},
                {3,4,Sign.EMPTY,Sign.EMPTY},
                {4,0,Sign.O,Sign.EMPTY},
                {4,1,Sign.EMPTY,Sign.EMPTY},
                {4,2,Sign.O,Sign.EMPTY},
                {4,3,Sign.O,Sign.EMPTY},
                {4,4,Sign.X,Sign.EMPTY},

        };
    }

    @Test(dataProvider = "netSizesGeneratorWhichAreOk")
    public void testSizeOfCreatedNet(int row, int column, int expected){
        NetCreator netCreator = new NetCreator(new NetSettings(row,column));
        Net net = netCreator.createNet();
        assert net.getNetSize() == expected;
    }

    //TODO: 5x5 again?
    @Test(dataProvider = "checkInitialFieldsIn5x5Net")
    public void testIfNewNetIsFulfilledWithEmptyFields(int row, int column, Sign expectedState){
        NetCreator netCreator = new NetCreator(new NetSettings(5,5));
        Net net = netCreator.createNet();
        assert net.getField(row, column).fieldSign.equals(expectedState);
    }

    @Test(dataProvider = "checkClearanceFor5x5Net")
    public void testNetClearance(int row, int column, Sign initial, Sign expected){
        NetCreator netCreator = new NetCreator(new NetSettings(5,5));
        Net net = netCreator.createNet();
        net.getField(row, column).changeState(initial);
        net = net.clearNet();
        assert net.getField(row, column).equals(new Field(expected));
    }




}
