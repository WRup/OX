package com.wrup.oxapp;

import org.testng.annotations.Test;

/**
 * @author Wiktor Rup
 */
@Test
public class BundleProviderTestClass {

    //TODO: we check only one language? :(
    @Test
    public void checkIfReturnsProperMessage() {

        BundleProvider bundleProvider = new BundleProvider("pl");
        assert bundleProvider.getMessage("wrong_input").equals("Podales zle dane. Sprobuj jeszcze raz.");
    }


}
