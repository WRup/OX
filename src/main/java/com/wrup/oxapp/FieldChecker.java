package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */
//TODO: didn't test this class
class FieldChecker {

    private int row;
    private int column;
    private Net net;

    FieldChecker(int row, int column, Net net) {
        this.row = row;
        this.column = column;
        this.net = net;
    }

    boolean checkField() {
        if (row < 0 || row >= net.howManyRows() || column < 0 || column >= net.howManyColumns()) {
            return false;
        } else {
            //TODO: do we check here if field is empty? so maybe only our checker knows what to do
            return isEmpty();
        }
    }

    private boolean isEmpty() {
        return net.getField(row, column).getFieldSign().equals(Sign.EMPTY);
    }
}

