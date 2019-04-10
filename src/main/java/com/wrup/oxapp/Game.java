package com.wrup.oxapp;

import java.util.List;
import java.util.Scanner;

/**
 * @author Wiktor Rup
 */
class Game {

    private Judge judge;
    private Auditor auditor;
    private Net net;
    private List<User> users;
    private Settings settings;
    private boolean winner = false;
    private int moveCounter;
    private int numberOfGames = 1;

    Game(Settings settings) {
        this.settings = settings;
        net = settings.createNet();
        users = settings.generateUsers();
        judge = new Judge(settings.getWinStreak());
        auditor = new Auditor(users);

    }

    void startGame(Scanner scanner) {
        moveCounter = net.getNetSize();
        UserProvider userProvider = new UserProvider();
        //TODO: so our output is wrapper to Scanner, but input is regular Scanner?
        Output output = new Output(scanner);
        Input input = new Input();

        while (numberOfGames <= 3) {
            //TODO: gameName isn't TicTacToe? how do I know that name is number? and why I need here BundleProvider? :o
            output.printGameName(numberOfGames, settings.getBundleProvider());
            while (!winner && moveCounter != 0) {
                //TODO: starting user is a list of users? what?
                User user = userProvider.startingUser(users);
                //TODO: what am I doing here? I need net, user, output, input, judge, auditor, pizza, beer, chips, money, hope, sun, world peace.. :p
                startRound(net, user, output, input, judge, auditor);
            }
            if(winner) {
                //TODO: I need BundleProvider everywhere but it is only kindly, ordinary, old friend - STRING
                output.printWinnerAnnouncement(auditor.winning(), settings.getBundleProvider());
                resetGame();
            } else {
                auditor.addDrawScore();
                output.printDrawAnnouncement(auditor.results(), settings.getBundleProvider());
                resetGame();
            }
            numberOfGames++;
        }

        output.printFinalResults(auditor.results(), settings.getBundleProvider());

    }

    //TODO: this class shouldn't be responsible for round
    private void startRound(Net net, User user, Output output, Input input, Judge judge, Auditor auditor) {

        output.printNet(net);
        String move = output.userMove(settings.getBundleProvider(), user);
        while (!input.checkIfUserMoveIsProper(move, user.getSign(), net)) {
            output.wrongInput(settings.getBundleProvider());
            move = output.userMove(settings.getBundleProvider(), user);
        }
        //TODO: I don't know why we count moves
        moveCounter--;

        if(judge.checkWinner(move, net)) {
            winner = true;
            output.printNet(net);
            auditor.addWinScore(user);
        }

    }

    private void resetGame() {
        winner = false;
        moveCounter = net.getNetSize();
        net = settings.createNet();
    }


}
