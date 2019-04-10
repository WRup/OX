package com.wrup.oxapp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Wiktor Rup
 */

@Test
public class FieldTestClass {

    @Test
    public void testIfEmptyFieldIsEmpty(){
        Field field = new Field(Sign.EMPTY);
        assert field.fieldSign.equals(Sign.EMPTY);
    }
    @Test
    public void testIfXFieldIsX(){
        Field field = new Field(Sign.X);
        assert field.fieldSign.equals(Sign.X);
    }
    @Test
    public void testIfOFieldIsO(){
        Field field = new Field(Sign.O);
        assert field.fieldSign.equals(Sign.O);
    }

    /*TODO: :p
    @Test
    public void testIfLittleSweetVermiculeIsLittleSweetVermicule() {
        LittleSweetVermicule littleSweetVermicule = new LittleSweetVermicule();
        assert littleSweetVermicule.equals(littleSweetVermicule);
    }*/

    @Test
    public void testFieldEquality(){
        Field emptyField = new Field(Sign.EMPTY);
        Field xField = new Field(Sign.X);
        Field oField = new Field(Sign.O);
        assert oField.equals(new Field(Sign.O));
        assert xField.equals(new Field(Sign.X));
        assert emptyField.equals(new Field(Sign.EMPTY));
    }

    //TODO: create new class for DataProvider
    @DataProvider
    public static Object[][] fieldStates(){
        return new Object[][]{
                {Sign.EMPTY, Sign.X, Sign.X},
                {Sign.EMPTY, Sign.O, Sign.O},
                {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY},
                {Sign.X, Sign.EMPTY, Sign.EMPTY},
                {Sign.X, Sign.O, Sign.X},
                {Sign.X, Sign.X, Sign.X},
                {Sign.O, Sign.EMPTY, Sign.EMPTY},
                {Sign.O, Sign.X, Sign.O},
                {Sign.O, Sign.O, Sign.O}
        };
    }

    @Test(dataProvider = "fieldStates")
    public void testFieldChangeState(Sign initial, Sign toChange, Sign expected){
        Field field = new Field(initial);
        field = field.changeState(toChange);
        assert field.fieldSign.equals(expected);
    }
}
