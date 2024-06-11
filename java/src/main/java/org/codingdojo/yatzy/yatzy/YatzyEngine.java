package org.codingdojo.yatzy.yatzy;

public class YatzyEngine {

    public static int compureScore(YatzyHand hand, DiceThrow diceThrow) {
        return hand.scoreFunction().compute(diceThrow);
    }
}
