package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;

public sealed interface ScoreFunction permits
    ChanceScorer, FullHouseScorer, NumberScorer, RepeatedCountScorer, TwoPairsScorer, YatzyScorer, StraightScorer {
    int compute(DiceThrow diceThrow);
}
