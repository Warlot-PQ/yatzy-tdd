package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;

import static org.codingdojo.yatzy.yatzy.scorer.helper.ScorerHelper.sum;

public final class ChanceScorer implements ScoreFunction {
    @Override
    public int compute(DiceThrow diceThrow) {
        return sum(diceThrow);
    }
}
