package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;
import org.codingdojo.yatzy.yatzy.scorer.helper.ScorerHelper;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.codingdojo.yatzy.yatzy.scorer.helper.ScorerHelper.frequencies;

public final class TwoPairsScorer implements ScoreFunction {
    private final int diceToComposeAPair = 2;

    @Override
    public int compute(DiceThrow diceThrow) {
        Map<Integer, Integer> frequencies = ScorerHelper.frequencies(diceThrow);
        List<Integer> list = frequencies.entrySet().stream()
            .filter(entry -> entry.getValue() >= diceToComposeAPair)
            .map(Map.Entry::getKey)
            .toList();
        return list.size() >= 2 ? list.stream().mapToInt(dice -> dice * diceToComposeAPair).sum() : 0;
    }
}
