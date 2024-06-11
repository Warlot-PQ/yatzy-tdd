package org.codingdojo.yatzy.yatzy;

import org.codingdojo.yatzy.yatzy.scorer.ChanceScorer;
import org.codingdojo.yatzy.yatzy.scorer.FullHouseScorer;
import org.codingdojo.yatzy.yatzy.scorer.NumberScorer;
import org.codingdojo.yatzy.yatzy.scorer.RepeatedCountScorer;
import org.codingdojo.yatzy.yatzy.scorer.ScoreFunction;
import org.codingdojo.yatzy.yatzy.scorer.StraightScorer;
import org.codingdojo.yatzy.yatzy.scorer.TwoPairsScorer;
import org.codingdojo.yatzy.yatzy.scorer.YatzyScorer;

public enum YatzyHand {
    SAME_ONE(new NumberScorer(1)),
    SAME_TWO(new NumberScorer(2)),
    SAME_THREE(new NumberScorer(3)),
    SAME_FOUR(new NumberScorer(4)),
    SAME_FIVE(new NumberScorer(5)),
    SAME_SIX(new NumberScorer(6)),
    CHANCE(new ChanceScorer()),
    YATZY(new YatzyScorer()),
    PAIR_ONE(new RepeatedCountScorer(2)),
    KIND_THREE(new RepeatedCountScorer(3)),
    KIND_FOUR(new RepeatedCountScorer(4)),
    PAIR_TWO(new TwoPairsScorer()),
    STRAIGHT_SMALL(new StraightScorer(1)),
    STRAIGHT_LARGE(new StraightScorer(6)),
    HOUSE_FULL(new FullHouseScorer());
    ;

    private final ScoreFunction scoreFunction;

    YatzyHand(ScoreFunction scoreFunction) {
        this.scoreFunction = scoreFunction;
    }

    public ScoreFunction scoreFunction() {
        return this.scoreFunction;
    }
}
