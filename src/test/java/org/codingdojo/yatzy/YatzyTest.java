package org.codingdojo.yatzy;

import org.codingdojo.yatzy.yatzy.DiceThrow;
import org.codingdojo.yatzy.yatzy.YatzyEngine;
import org.codingdojo.yatzy.yatzy.YatzyHand;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyTest {

    private static Stream<Arguments> handTest() {
        return Stream.of(
            Arguments.of(YatzyHand.CHANCE, DiceThrow.of(2,3,4,5,1), 15),
            Arguments.of(YatzyHand.CHANCE, DiceThrow.of(3,3,4,5,1), 16),
            Arguments.of(YatzyHand.YATZY, DiceThrow.of(4,4,4,4,4), 50),
            Arguments.of(YatzyHand.YATZY, DiceThrow.of(6,6,6,6,6), 50),
            Arguments.of(YatzyHand.YATZY, DiceThrow.of(6,6,6,6,3), 0),
            Arguments.of(YatzyHand.SAME_ONE, DiceThrow.of(1,2,3,4,5), 1),
            Arguments.of(YatzyHand.SAME_ONE, DiceThrow.of(1,2,1,4,5), 2),
            Arguments.of(YatzyHand.SAME_ONE, DiceThrow.of(6,2,2,4,5), 0),
            Arguments.of(YatzyHand.SAME_ONE, DiceThrow.of(1,2,1,1,1), 4),
            Arguments.of(YatzyHand.SAME_TWO, DiceThrow.of(1,2,3,2,6), 4),
            Arguments.of(YatzyHand.SAME_TWO, DiceThrow.of(2,2,2,2,2), 10),
            Arguments.of(YatzyHand.SAME_THREE, DiceThrow.of(1,2,3,2,3), 6),
            Arguments.of(YatzyHand.SAME_THREE, DiceThrow.of(2,3,3,3,3), 12),
            Arguments.of(YatzyHand.SAME_FOUR, DiceThrow.of(4,4,4,5,5), 12),
            Arguments.of(YatzyHand.SAME_FOUR, DiceThrow.of(4,4,5,5,5), 8),
            Arguments.of(YatzyHand.SAME_FOUR, DiceThrow.of(4,5,5,5,5), 4),
            Arguments.of(YatzyHand.SAME_FIVE, DiceThrow.of(4,4,4,5,5), 10),
            Arguments.of(YatzyHand.SAME_FIVE, DiceThrow.of(4,4,5,5,5), 15),
            Arguments.of(YatzyHand.SAME_FIVE, DiceThrow.of(4,5,5,5,5), 20),
            Arguments.of(YatzyHand.SAME_SIX, DiceThrow.of(4,4,4,5,5), 0),
            Arguments.of(YatzyHand.SAME_SIX, DiceThrow.of(4,4,6,5,5), 6),
            Arguments.of(YatzyHand.SAME_SIX, DiceThrow.of(6,5,6,6,5), 18),
            Arguments.of(YatzyHand.PAIR_ONE, DiceThrow.of(3,4,3,5,6), 6),
            Arguments.of(YatzyHand.PAIR_ONE, DiceThrow.of(5,3,3,3,5), 10),
            Arguments.of(YatzyHand.PAIR_ONE, DiceThrow.of(5,3,6,6,5), 12),
            Arguments.of(YatzyHand.PAIR_TWO, DiceThrow.of(3,3,5,4,5), 16),
            Arguments.of(YatzyHand.PAIR_TWO, DiceThrow.of(3,3,5,5,5), 16),
            Arguments.of(YatzyHand.KIND_THREE, DiceThrow.of(3,3,3,4,5), 9),
            Arguments.of(YatzyHand.KIND_THREE, DiceThrow.of(5,3,5,4,5), 15),
            Arguments.of(YatzyHand.KIND_THREE, DiceThrow.of(3,3,3,3,5), 9),
            Arguments.of(YatzyHand.KIND_THREE, DiceThrow.of(3,3,3,3,3), 9),
            Arguments.of(YatzyHand.KIND_FOUR, DiceThrow.of(3,3,3,3,5), 12),
            Arguments.of(YatzyHand.KIND_FOUR, DiceThrow.of(5,5,5,4,5), 20),
            Arguments.of(YatzyHand.KIND_FOUR, DiceThrow.of(3,3,3,3,3), 12),
            Arguments.of(YatzyHand.STRAIGHT_SMALL, DiceThrow.of(1,2,3,4,5), 15),
            Arguments.of(YatzyHand.STRAIGHT_SMALL, DiceThrow.of(2,3,4,5,1), 15),
            Arguments.of(YatzyHand.STRAIGHT_SMALL, DiceThrow.of(1,2,2,4,5), 0),
            Arguments.of(YatzyHand.STRAIGHT_LARGE, DiceThrow.of(6,2,3,4,5), 20),
            Arguments.of(YatzyHand.STRAIGHT_LARGE, DiceThrow.of(2,3,4,5,6), 20),
            Arguments.of(YatzyHand.STRAIGHT_LARGE, DiceThrow.of(1,2,2,4,5), 0),
            Arguments.of(YatzyHand.HOUSE_FULL, DiceThrow.of(6,2,2,2,6), 18),
            Arguments.of(YatzyHand.HOUSE_FULL, DiceThrow.of(2,3,4,5,6), 0)
        );
    }

    @MethodSource
    @ParameterizedTest
    public void handTest(YatzyHand hand, DiceThrow diceThrow, int scoreExpected) {
        // When
        int actual = YatzyEngine.computeScore(hand, diceThrow);
        // Then
        assertEquals(
            scoreExpected,
            actual,
            "hand: %s with %s scored %s instead of %s".formatted(
                hand, diceThrow, actual, scoreExpected
            )
        );
    }
}
