package blackjack.domain.player;

import blackjack.domain.card.PlayingCard;
import blackjack.domain.card.PlayingCards;
import blackjack.domain.state.*;

import java.util.Objects;

public abstract class AbstractPlayer implements Player {

    protected String name;
    protected State state;

    protected AbstractPlayer(String name, State state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public final void stay() {
        this.state = state.stay();
    }

    @Override
    public final void draw(PlayingCard playingCard) {
        this.state = state.draw(playingCard);
    }

    @Override
    public final boolean isRunning() {
        return state.isRunning();
    }

    @Override
    public final boolean isHit() {
        return state.playingCards().calculatePoints() < limitHit();
    }

    @Override
    public final boolean isBust() {
        return state.playingCards().isBust();
    }

    @Override
    public final boolean isBlackjack() {
        return state.playingCards().isBlackjack();
    }

    @Override
    public final boolean isDraw(PlayingCards playingCards) {
        return state.playingCards().calculatePoints() == playingCards.calculatePoints();
    }

    @Override
    public final boolean isLose(PlayingCards playingCards) {
        return state.playingCards().calculatePoints() < playingCards.calculatePoints();
    }

    protected abstract int limitHit();

    @Override
    public final PlayingCards playingCards() {
        return state.playingCards();
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final State getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlayer that = (AbstractPlayer) o;
        return Objects.equals(name, that.name) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }
}