package au.com.dius

import spock.lang.Specification
import spock.lang.Unroll

class BowlingGameSpockTest extends Specification {

    @Unroll("#description")
    def "bowling game tests"() {
        given:
        ComplexBowlingGame game = new ComplexBowlingGame()

        when:
        performRolls(game, f1r1, f1r2, f2r1, f2r2, f3r1, f3r2, f4r1, f4r2, f5r1, f5r2, f6r1, f6r2, f7r1, f7r2, f8r1, f8r2, f9r1, f9r2, f10r1, f10r2, f10r3)

        then:
        game.score() == score

        where:
        description                | f1r1 | f1r2 | f2r1 | f2r2 | f3r1 | f3r2 | f4r1 | f4r2 | f5r1 | f5r2 | f6r1 | f6r2 | f7r1 | f7r2 | f8r1 | f8r2 | f9r1 | f9r2 | f10r1 | f10r2 | f10r3 || score
        'all zeroes'               | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0     | 0     | null  || 0
        'all ones'                 | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1     | 1     | null  || 20
        'one spare'                | 7    | 3    | 2    | 5    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0     | 0     | null  || 19
        'one strike'               | 10   | null | 6    | 3    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0     | 0     | null  || 28
        'one strike and one spare' | 10   | null | 6    | 4    | 5    | 4    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0     | 0     | null  || 44
        'spare with zero then ten' | 0    | 10   | 3    | 4    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0     | 0     | null  || 20
        'ten pins not spare'       | 0    | 7    | 3    | 2    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0     | 0     | null  || 12
        'all strikes'              | 10   | null | 10   | null | 10   | null | 10   | null | 10   | null | 10   | null | 10   | null | 10   | null | 10   | null | 10    | 10    | 10    || 300
        'all spares'               | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5    | 5     | 5     | 5     || 150
        'final frame strike'       | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 10    | 10    | 10    || 30
        'final frame spare'        | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 9     | 1     | 10    || 20
    }

    void performRolls(ComplexBowlingGame game, Integer... rolls) {
        rolls.each { if (it != null) game.roll(it) }
    }
}
