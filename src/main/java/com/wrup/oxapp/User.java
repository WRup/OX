package com.wrup.oxapp;

import java.util.Objects;

/**
 * @author Wiktor Rup
 */
class User implements Comparable {

    private Sign sign;
    private int score;
    //TODO: what if both of players have true as 'isFirst'?
    private boolean isFirst;

    User(Sign sign, boolean isFirst) {
        this.sign = sign;
        score = 0;
        this.isFirst = isFirst;
    }

    void addScore(int i) {
        score += i;
    }

    //TODO:auto-generated?
    @Override
    public int hashCode() {
        return Objects.hash(sign, score, isFirst);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return score == user.score &&
                isFirst == user.isFirst &&
                sign == user.sign;
    }

    @Override
    public String toString() {
        return sign.toString();
    }

    Sign getSign() {
        return sign;
    }

    int getScore() {
        return score;
    }

    boolean isFirst() {
        return isFirst;
    }

    User changePriority() {
        this.isFirst = !isFirst;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.getScore(), ((User) o).getScore());
    }
}
