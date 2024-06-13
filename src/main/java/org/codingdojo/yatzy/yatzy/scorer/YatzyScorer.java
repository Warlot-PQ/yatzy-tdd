package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;

public final class YatzyScorer implements ScoreFunction {
    @Override
    public int compute(DiceThrow diceThrow) {
        return diceThrow.dices().stream().distinct().count() == 1 ? 50 : 0;
    }
}
