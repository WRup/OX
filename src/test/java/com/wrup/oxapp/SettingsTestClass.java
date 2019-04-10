package com.wrup.oxapp;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wiktor Rup
 */
@Test
public class SettingsTestClass {

    @Test
    public void testGeneratedUsers() {
        Settings settings = new Settings();
        //TODO: who is starting now? :D naught(y) O or cROSS (watch Friends!) X?
        settings.setStartPlayer(69);
        List<User> userList = new ArrayList<User>();
        userList.add(new User(Sign.O, true));
        userList.add(new User(Sign.X, false));

        assert userList.equals(settings.generateUsers());
    }

    @Test
    public void testGeneratedNet(){
        Settings settings = new Settings();
        //TODO: not 5x5? :p
        settings.setNetSize(3,3);

        NetSettings netSettings = new NetSettings(3,3);
        Net net = new NetCreator(netSettings).createNet();

        assert settings.createNet().getNetSize() == net.getNetSize();
    }

    @Test
    public void testBundleResources(){
        Settings settings = new Settings();
        settings.setBundleProvider(1);

        assert new BundleProvider("pl").equals(settings.getBundleProvider());
    }

    @Test
    public void checkIfReturnsProperWinStreak(){
        Settings settings = new Settings();
        settings.setWinStreak(4);

        assert settings.getWinStreak() == 4;
    }
}
