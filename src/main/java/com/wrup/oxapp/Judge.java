package com.wrup.oxapp;

//TODO: all of classes was write by Wiktor Rup, but not this one? :(
class Judge {

    private int row;
    private int column;
    private Net net;
    private int winStreak;
    private int cross = 0;
    private int circle = 0;

    Judge(int row, int column, Net net, int winStreak) {
        this.row = row;
        this.column = column;
        this.net = net;
        this.winStreak = winStreak;
    }

    //TODO: isn't it better to give Judge game options? he should know all conditions
    Judge(int winStreak) {
        this.winStreak = winStreak;
    }

    //TODO: why move is a String? :(
    boolean checkWinner(String move, Net net) {
        String[] coords = new StringConverter(move).splitString(",");
        row = new StringConverter(coords[0]).parseToInt();
        column = new StringConverter(coords[1]).parseToInt();
        this.net = net;
        //TODO: Intellij said it is better look.. ctrl+alt+l
        return checkHorizontal(row, column, net) || checkVertical(row, column, net) || checkDiagonal(row,
                column,
                net) || checkAntiDiagonal(
                row,
                column,
                net);
    }

    //TODO: we don't have some clever checker? maybe judge doesn't know the game rules
    private boolean checkHorizontal(int row, int column, Net net) {
        resetCounters();
        for (int i = column + winStreak; i > column - winStreak; i--) {
            if (row < net.howManyRows() && i < net.howManyColumns() && i >= 0) {
                isCrossOrCircle(row, i);
            }
        }
        return cross >= winStreak || circle >= winStreak;
    }

    //TODO: better will be remembering cross and circle (in specification it is naught :p) separately
    // and check in each round only one of them
    private void isCrossOrCircle(int row, int column) {
        if (net.getField(row, column).fieldSign.equals(Sign.X)) {
            cross++;
            circle--;
        } else if (net.getField(row, column).fieldSign.equals(Sign.O)) {
            circle++;
            cross--;
        }
    }

    private void resetCounters() {
        circle = 0;
        cross = 0;
    }

    private boolean checkVertical(int row, int column, Net net) {
        resetCounters();
        for (int i = row - winStreak; i < row + winStreak; i++) {
            if (i < net.howManyRows() && i >= 0 && column < net.howManyColumns()) {
                isCrossOrCircle(i, column);
            }
        }
        return cross >= winStreak || circle >= winStreak;
    }

    private boolean checkDiagonal(int row, int column, Net net) {
        resetCounters();
        for (int i = row - winStreak, j = column - winStreak; i < row + winStreak; j++, i++) {
            if (i < net.howManyRows() && i >= 0 && j < net.howManyColumns() && j >= 0) {
                isCrossOrCircle(i, j);
            }
        }
        return cross >= winStreak || circle >= winStreak;
    }

    private boolean checkAntiDiagonal(int row, int column, Net net) {
        resetCounters();
        for (int i = row - winStreak, j = column + winStreak; i < row + winStreak; j--, i++) {
            if (i < net.howManyRows() && i >= 0 && j < net.howManyColumns() && j >= 0) {
                isCrossOrCircle(i, j);
            }
        }
        return cross >= winStreak || circle >= winStreak;
    }


}
