package com.wrup.oxapp;

import org.testng.annotations.Test;

/**
 * @author Wiktor Rup
 */
//TODO: only one class without my comment, so I need to write here something :D you'r welcome ;)
@Test
public class JudgeTestClass {


    @Test
    public void checkHorizontal() {
        NetSettings netSettings = new NetSettings(5, 5);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        MoveMaker moveMaker = new MoveMaker(Sign.X, 1, 1, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 1, 0, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 1, 2, net);
        moveMaker.putSign();

        Judge judge = new Judge(3);
        assert judge.checkWinner("1,1", net);
    }

    @Test
    public void checkVertical(){
        NetSettings netSettings = new NetSettings(3, 3);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        MoveMaker moveMaker = new MoveMaker(Sign.X, 1, 1, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 0, 1, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 2, 1, net);
        moveMaker.putSign();

        Judge judge = new Judge(3);
        assert judge.checkWinner("1,1", net);
    }

    @Test
    public void checkAntiDiagonal(){
        NetSettings netSettings = new NetSettings(3, 3);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        MoveMaker moveMaker = new MoveMaker(Sign.X, 0, 0, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 1, 1, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 2, 2, net);
        moveMaker.putSign();

        Judge judge = new Judge(3);
        assert judge.checkWinner("1,1", net);
    }

    @Test
    public void checkDiagonal(){
        NetSettings netSettings = new NetSettings(3, 3);
        NetCreator netCreator = new NetCreator(netSettings);
        Net net = netCreator.createNet();
        MoveMaker moveMaker = new MoveMaker(Sign.X, 2, 0, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 1, 1, net);
        moveMaker.putSign();
        moveMaker = new MoveMaker(Sign.X, 0, 2, net);
        moveMaker.putSign();

        Judge judge = new Judge(3);
        assert judge.checkWinner("1,1", net);
    }
}
