package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */
class MoveMaker {
    private Sign signToPut;
    private int row;
    private int column;
    private Net net;
    private FieldChecker fieldChecker;

    MoveMaker(Sign signToPut, int row, int column, Net net) {
        this.signToPut = signToPut;
        this.row = row;
        this.column = column;
        this.net = net;
        fieldChecker = new FieldChecker(row, column, net);
    }

    boolean putSign() {
        if (fieldChecker.checkField()) {
            //TODO: get().set() uuu beautiful :p maybe something like net.checkField(field, sign)..?
            net.getField(row, column).setFieldSign(signToPut);
            return true;
        } else {
            return false;
        }
    }

    Sign getSignToPut() {
        return signToPut;
    }
}
