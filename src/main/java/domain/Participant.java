package domain;

public abstract class Participant {

    private static final int INITIAL_CARDS_SIZE = 2;

    protected final String name;
    protected final Cards cards;

    protected Participant(String name, Cards cards) {
        validateCardsSize(cards);
        this.name = name;
        this.cards = cards;
    }

    private void validateCardsSize(Cards cards) {
        if (cards.getSize() != INITIAL_CARDS_SIZE) {
            throw new IllegalArgumentException("초기 카드는 2장이어야 합니다.");
        }
    }

    public Card pickCard(CardDeck cardDeck) {
        return cardDeck.pick();
    }

    public void hit(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public abstract boolean canAddCard();

    public Cards getCards() {
        return cards;
    }
}
