package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;
import org.codingdojo.yatzy.yatzy.scorer.helper.ScorerHelper;

import java.util.Map;

public final class RepeatedCountScorer implements ScoreFunction {

    private final int count;

    public RepeatedCountScorer(int count) {
        this.count = count;
    }

    @Override
    public int compute(DiceThrow diceThrow) {
        Map<Integer, Integer> frequencies = ScorerHelper.frequencies(diceThrow);
        return frequencies.entrySet().stream()
                .filter(entry -> entry.getValue() >= count)
                .map(entry -> entry.getKey() * count)
                .findFirst()
                .orElse(0);
    }
}
