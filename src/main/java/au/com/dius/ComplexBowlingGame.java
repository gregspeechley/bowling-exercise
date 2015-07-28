package au.com.dius;

import java.util.ArrayList;
import java.util.List;

public class ComplexBowlingGame implements BowlingGame {

    private List<Frame> frames;
    private int frameIndex = 0;
    private Frame currentFrame;

    public ComplexBowlingGame() {
        frames = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            frames.add(new Frame());
        }
        frames.add(new FinalFrame());
        currentFrame = frames.get(frameIndex);
    }

    @Override
    public void roll(int numberOfPins) {
        currentFrame.roll(numberOfPins);
        if (currentFrame.isComplete() && !currentFrame.isFinal()) {
            currentFrame = frames.get(++frameIndex);
        }
    }

    @Override
    public int score() {
        int index = 0;
        int score = 0;
        for (Frame frame : frames) {
            if (frame.isStrike() && !frame.isFinal()) {
                score += 10 + strikeBonus(index);
            } else if (frame.isSpare() && !frame.isFinal()) {
                score += 10 + spareBonus(index);
            } else {
                score += frame.calculateScore();
            }
            index++;
        }
        return score;
    }

    private int spareBonus(int index) {
        Frame nextFrame = frames.get(index + 1);
        return nextFrame.getRolls()[0];
    }

    private int strikeBonus(int index) {
        Frame nextFrame = frames.get(index + 1);
        if (nextFrame.isStrike() && !nextFrame.isFinal()) {
            return nextFrame.getRolls()[0] + frames.get(index + 2).getRolls()[0];
        } else {
            return nextFrame.getRolls()[0] + nextFrame.getRolls()[1];
        }
    }
}
