package org.codingdojo.yatzy.yatzy;

public class YatzyEngine {

    public static int computeScore(YatzyHand hand, DiceThrow diceThrow) {
        return hand.scoreFunction().compute(diceThrow);
    }
}
