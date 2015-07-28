package au.com.dius;

public class SimpleBowlingGame implements BowlingGame {

    public static final int MAX_ROLLS_IN_GAME = 21;
    public static final int NUMBER_OF_FRAMES = 10;
    public static final int NUMBER_OF_PINS = 10;

    private int[] rolls = new int[MAX_ROLLS_IN_GAME];
    private int currentRollNumber = 0;

    @Override
    public void roll(int numberOfPins) {
        rolls[currentRollNumber++] = numberOfPins;
    }

    @Override
    public int score() {
        int score = 0;
        int rollNumber = 0;
        for (int frame = 0; frame < NUMBER_OF_FRAMES; frame++) {
            if (isStrike(rollNumber)) {
                score += NUMBER_OF_PINS + strikeBonus(rollNumber);
                rollNumber++;
            } else if (isSpare(rollNumber)) {
                score += NUMBER_OF_PINS + spareBonus(rollNumber);
                rollNumber += 2;
            } else {
                score += sumOfPinsInFrame(rollNumber);
                rollNumber += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollNumber) {
        return rolls[rollNumber] == NUMBER_OF_PINS;
    }

    private boolean isSpare(int rollNumber) {
        return (rolls[rollNumber] + rolls[rollNumber + 1]) == NUMBER_OF_PINS;
    }

    private int strikeBonus(int rollNumber) {
        return rolls[rollNumber + 1] + rolls[rollNumber + 2];
    }

    private int spareBonus(int rollNumber) {
        return rolls[rollNumber + 2];
    }

    private int sumOfPinsInFrame(int rollNumber) {
        return rolls[rollNumber] + rolls[rollNumber + 1];
    }
}
