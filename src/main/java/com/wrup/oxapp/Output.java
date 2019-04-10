package com.wrup.oxapp;

import java.util.Scanner;

/**
 * @author Wiktor Rup
 */

//TODO: I've got very similar class :p
class Output {

    private MessagePrinter messagePrinter = new MessagePrinter();
    private Scanner scanner;

    Output() {
        scanner = new Scanner(System.in);
    }

    Output(Scanner scanner) {
        this.scanner = scanner;
    }

    //TODO: once again.. what if I want to have 274 languages?
    String chooseLanguage() {
        messagePrinter.print("Wybierz jezyk/Choose langauge:");
        messagePrinter.print("1. Polski");
        messagePrinter.print("2. English");
        return scanner.nextLine();
    }

    String chooseWhoStarts(BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("who_starts"));
        return scanner.nextLine();
    }

    String setHeightOfNet(BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("net_height"));
        return scanner.nextLine();
    }

    String setWidthOfNet(BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("net_width"));
        return scanner.nextLine();
    }

    String setWinStreak(BundleProvider bundleProvider) {
        messagePrinter.print(
                bundleProvider.getMessage("win_conditions"));
        return scanner.nextLine();
    }

    void wrongInput(BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("wrong_input"));
    }

    String userMove(BundleProvider bundleProvider, User user) {
        messagePrinter.print(bundleProvider.getMessage("player_move"), user.toString());
        return scanner.nextLine();
    }

    void printWinnerAnnouncement(String[] winner, BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("winner"), winner);
    }

    void printDrawAnnouncement(String[] draws, BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("draw"), draws);
    }

    void printGameName(int gameNumber, BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("game"), String.valueOf(gameNumber));
    }

    void printFinalResults(String[] results, BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("end_game"), results);
    }

    void printQuitMessage(BundleProvider bundleProvider) {
        messagePrinter.print(bundleProvider.getMessage("quit"));
    }

    void wrongLanguage() {
        messagePrinter.print("Wrong data. Try again!/Zly wybor. Sprobuj jeszcze raz.");
    }

    void printNet(Net net) {
        NetPrinter netPrinter = new NetPrinter(net);
        netPrinter.printNet();
    }
}
