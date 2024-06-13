package org.codingdojo.yatzy.yatzy.scorer;

import org.codingdojo.yatzy.yatzy.DiceThrow;

public final class NumberScorer implements ScoreFunction {

    private final int diceExpected;

    public NumberScorer(int diceExpected) {
        this.diceExpected = diceExpected;
    }


    @Override
    public int compute(DiceThrow diceThrow) {
        return (int) diceThrow.dices().stream().filter(dice -> dice == diceExpected).count() * diceExpected;
    }
}
