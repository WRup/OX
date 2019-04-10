package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */
//TODO: this is board, yes? :D
class Net {

    private Field[][] fields;

    Net(Field[][] fields) {
        this.fields = fields;
    }

    //TODO: why we don't have field to remember net size?
    int getNetSize() {
        int netSize = 0;
        for (Field[] field : fields) {
            netSize += field.length;
        }
        return netSize;
    }

    Field getField(int row, int column) {
        return fields[row][column];
    }

    Net clearNet() {
        for (Field[] row : fields) {
            for (Field column : row) {
                column.changeState(Sign.EMPTY);
            }
        }
        return new Net(fields);
    }

    int howManyColumns() {
        return fields[0].length;
    }

    int howManyRows() {
        return fields.length;
    }
}
