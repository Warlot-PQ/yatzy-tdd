package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;
import org.codingdojo.yatzy.yatzy.scorer.helper.ScorerHelper;

import java.util.Map;

public final class FullHouseScorer implements ScoreFunction {
    @Override
    public int compute(DiceThrow diceThrow) {
        Map<Integer, Integer> frequencies = ScorerHelper.frequencies(diceThrow);
        if (frequencies.containsValue(2) && frequencies.containsValue(3)) {
            return ScorerHelper.sum(diceThrow);
        }
        return 0;
    }
}
