package blackjack.domain.state;

import blackjack.domain.card.Cards;
import blackjack.domain.result.BlackjackMatch;

public class Bust extends Finished {

    private static final double BUST_RATE = -1;

    Bust(Cards cards) {
        super(cards);
    }

    @Override
    public BlackjackMatch match(State state) {
        return BlackjackMatch.LOSE;
    }

    @Override
    public double profitRate(BlackjackMatch blackjackMatch) {
        return BUST_RATE;
    }

    @Override
    public boolean isBust() {
        return true;
    }
}