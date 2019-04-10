package com.wrup.oxapp;

/**
 * @author Wiktor Rup
 */
class NetPrinter {

    private Net net;

    NetPrinter(Net net) {
        this.net = net;
    }

    void printNet() {
        System.out.println();
        printColumnNumbers();
        System.out.println();
        printUpperBorder();
        for (int row = 0; row < net.howManyRows(); row++) {
            System.out.println();
            if (String.valueOf(row).length() == 2) {
                System.out.print(" " + row + "|");
            } else {
                System.out.print(" " + row + " |");
            }
            for (int column = 0; column < net.howManyColumns(); column++) {
                printSign(net.getField(row, column));
            }
            System.out.println();
            System.out.print("---*");
            //TODO: instead of loop you can use Collections.nCopies(howManyTimes, "whatToPrint");
            for (int column = 0; column < net.howManyColumns(); column++) {
                System.out.print("---*");
            }

        }
        System.out.println();
    }

    private void printColumnNumbers() {
        System.out.print("   |");
        for (int column = 0; column < net.howManyColumns(); column++) {
            if (String.valueOf(column).length() == 2) {
                System.out.print(" " + column + "|");
            } else {
                System.out.print(" " + column + " |");
            }
        }
    }

    private void printUpperBorder() {
        System.out.print("---*");
        //TODO: up..
        for (int column = 0; column < net.howManyColumns(); column++) {
            System.out.print("---*");
        }
    }

    private void printSign(Field field) {
        if (field.getFieldSign().equals(Sign.X)) {
            System.out.print(" X |");
        } else if (field.getFieldSign().equals(Sign.O)) {
            System.out.print(" O |");
        } else {
            System.out.print("   |");
        }
    }
}
