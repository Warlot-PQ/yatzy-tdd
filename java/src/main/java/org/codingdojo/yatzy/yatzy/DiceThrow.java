package org.codingdojo.yatzy.yatzy;

import java.util.List;

public class DiceThrow {

    private final List<Integer> dices;

    private DiceThrow(int d1, int d2, int d3, int d4, int d5) {
        this.dices = List.of(d1, d2, d3, d4, d5);
    }

    public List<Integer> dices() {
        return dices;
    }

    public static DiceThrow of(int d1, int d2, int d3, int d4, int d5) {
        return new DiceThrow(d1, d2, d3, d4, d5);
    }

    @Override
    public String toString() {
        return "DiceThrow{" +
            "dices=" + dices +
            '}';
    }
}
