package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;
import org.codingdojo.yatzy.yatzy.scorer.helper.ScorerHelper;

import java.util.Arrays;
import java.util.Map;

public final class RepeatedCountScorer implements ScoreFunction {

    private final int count;

    public RepeatedCountScorer(int count) {
        this.count = count;
    }

    @Override
    public int compute(DiceThrow diceThrow) {
        Map<Integer, Integer> frequencies = ScorerHelper.frequencies(diceThrow);
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            Integer dice = entry.getKey();
            Integer frequency = entry.getValue();
            if (frequency >= count) {
                return dice * count;
            }
        }
        return 0;
    }
}
