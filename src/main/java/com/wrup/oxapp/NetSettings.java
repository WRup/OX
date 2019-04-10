package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */
//TODO: it's net settings or net size?
class NetSettings {

    private final int row;
    private final int column;

    NetSettings(int row, int column) {
        this.row = row;
        this.column = column;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }
}
