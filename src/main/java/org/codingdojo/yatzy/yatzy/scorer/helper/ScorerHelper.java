package org.codingdojo.yatzy.yatzy.scorer.helper;

import org.codingdojo.yatzy.yatzy.DiceThrow;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ScorerHelper {

    public static Map<Integer, Integer> frequencies(DiceThrow diceThrow) {
        Map<Integer, Integer> frequencies = new TreeMap<>(Collections.reverseOrder());
        diceThrow.dices().forEach(dice -> frequencies.compute(dice, (key, value) -> value == null ? 1 : value + 1));
        return frequencies;
    }

    public static int sum(DiceThrow diceThrow) {
        return diceThrow.dices().stream().mapToInt(Integer::intValue).sum();
    }

    public static boolean isStraight(DiceThrow diceThrow) {
        return frequencies(diceThrow).values().stream().filter(f -> f == 1).toList().size() == 5;
    }
}
