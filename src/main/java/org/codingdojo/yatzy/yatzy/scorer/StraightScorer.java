package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;
import org.codingdojo.yatzy.yatzy.scorer.helper.ScorerHelper;

public final class StraightScorer implements ScoreFunction {

    private final int straightIncludes;

    public StraightScorer(int straightIncludes) {
        this.straightIncludes = straightIncludes;
    }

    @Override
    public int compute(DiceThrow diceThrow) {
        if (ScorerHelper.isStraight(diceThrow) && ScorerHelper.frequencies(diceThrow).get(straightIncludes) != 0) {
            return ScorerHelper.sum(diceThrow);
        }
        return 0;
    }
}
