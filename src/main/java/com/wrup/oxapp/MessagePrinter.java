package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */
//TODO: we use it only in one class, maybe it could be private method
class MessagePrinter {

    void print(String rb, String... text) {
        if (text.length != 0) {
            System.out.println(String.format(rb, text));
        } else {
            System.out.println(rb);
        }
    }
}
