package com.wrup.oxapp;

//TODO: next sad class belonging to no one
class StringConverter {

    private String text;

    StringConverter(String text) {
        this.text = text;
    }

    Integer parseToInt() {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            //TODO: maybe ask player once again
            return -1;
        }
    }

    String[] splitString(String pattern) {
        return text.split(pattern);
    }

}
