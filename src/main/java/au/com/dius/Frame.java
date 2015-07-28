package au.com.dius;

public class Frame {

    protected int index = 0;
    protected int[] rolls;

    public Frame() {
        this.rolls = new int[2];
    }

    public int[] getRolls() {
        return rolls;
    }

    public void roll(int numberOfPins) {
        if (!isComplete()) {
            this.rolls[index++] = numberOfPins;
        }
    }

    public int calculateScore() {
        int score = 0;
        for (int roll : rolls) {
            score += roll;
        }
        return score;
    }

    public boolean isStrike() {
        return rolls[0] == 10;
    }

    public boolean isSpare() {
        return (rolls[0] + rolls[1]) == 10;
    }

    public boolean isComplete() {
        return (isStrike() || index > 1);
    }

    public boolean isFinal() {
        return false;
    }
}
