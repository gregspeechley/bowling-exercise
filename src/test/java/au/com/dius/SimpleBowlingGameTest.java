package au.com.dius;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleBowlingGameTest {

    private SimpleBowlingGame simpleBowlingGame;

    @Before
    public void setUp() {
        simpleBowlingGame = new SimpleBowlingGame();
    }

    @Test
    public void allZeroes() {
        performRepetitiveRolls(20, 0);
        assertThat(simpleBowlingGame.score(), is(0));
    }

    @Test
    public void allOnes() {
        performRepetitiveRolls(20, 1);
        assertThat(simpleBowlingGame.score(), is(20));
    }

    @Test
    public void oneSpare() {
        performRolls(3, 7, 2, 5);
        assertThat(simpleBowlingGame.score(), is(19));
    }

    @Test
    public void oneStrike() {
        performRolls(10, 6, 3, 7);
        assertThat(simpleBowlingGame.score(), is(35));
    }

    @Test
    public void tenPinsInSuccessiveRollsButNotASpare() {
        performRolls(0, 7, 3, 2);
        assertThat(simpleBowlingGame.score(), is(12));
    }

    @Test
    public void oneStrikeAndOneSpare() {
        performRolls(10, 6, 4, 5, 4);
        assertThat(simpleBowlingGame.score(), is(44));
    }

    @Test
    public void zeroThenTen() {
        performRolls(0, 10, 3, 4);
        assertThat(simpleBowlingGame.score(), is(20));
    }

    @Test
    public void allStrikes() {
        performRepetitiveRolls(12, 10);
        assertThat(simpleBowlingGame.score(), is(300));
    }

    @Test
    public void allSparesThenFinalStrike() {
        performRolls(9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 10);
        assertThat(simpleBowlingGame.score(), is(191));
    }

    @Test
    public void nineStrikesThenSpareAndStrike() {
        performRepetitiveRolls(9, 10);
        performRolls(9, 1, 10);
        assertThat(simpleBowlingGame.score(), is(279));
    }

    private void performRepetitiveRolls(int numberOfRolls, int pins) {
        for (int i = 0; i < numberOfRolls; i++) {
            simpleBowlingGame.roll(pins);
        }
    }

    private void performRolls(Integer... rolls) {
        for (int numberOfPins : rolls) {
            simpleBowlingGame.roll(numberOfPins);
        }
    }
}