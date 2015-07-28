package au.com.dius;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ComplexBowlingGameTest {

    ComplexBowlingGame complexBowlingGame;

    @Before
    public void setUp() throws Exception {
        complexBowlingGame = new ComplexBowlingGame();
    }

    @Test
    public void allZeroes() {
        performRepetitiveRolls(20, 0);
        assertThat(complexBowlingGame.score(), is(0));
    }

    @Test
    public void allOnes() {
        performRepetitiveRolls(20, 1);
        assertThat(complexBowlingGame.score(), is(20));
    }

    @Test
    public void oneSpare() {
        performRolls(3, 7, 2, 5);
        assertThat(complexBowlingGame.score(), is(19));
    }

    @Test
    public void oneStrike() {
        performRolls(10, 6, 3, 7);
        assertThat(complexBowlingGame.score(), is(35));
    }

    @Test
    public void tenPinsInSuccessiveRollsButNotASpare() {
        performRolls(0, 7, 3, 2);
        assertThat(complexBowlingGame.score(), is(12));
    }

    @Test
    public void oneStrikeAndOneSpare() {
        performRolls(10, 6, 4, 5, 4);
        assertThat(complexBowlingGame.score(), is(44));
    }

    @Test
    public void zeroThenTen() {
        performRolls(0, 10, 3, 4);
        assertThat(complexBowlingGame.score(), is(20));
    }

    @Test
    public void allStrikes() {
        performRepetitiveRolls(12, 10);
        assertThat(complexBowlingGame.score(), is(300));
    }

    private void performRepetitiveRolls(int numberOfRolls, int pins) {
        for (int i = 0; i < numberOfRolls; i++) {
            complexBowlingGame.roll(pins);
        }
    }

    private void performRolls(Integer... rolls) {
        for (int numberOfPins : rolls) {
            complexBowlingGame.roll(numberOfPins);
        }
    }
}