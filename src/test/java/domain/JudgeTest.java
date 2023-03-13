package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    @Test
    @DisplayName("딜러 카드의 합이 21을 초과할 경우 플레이어는 베팅 금액만큼의 수익을 얻는다")
    void PlayerWinWhenSumOfDealerCarsIsOver21() {
        Name name = Name.generatePlayerName("roy");
        Cards playerCards = new Cards(List.of(new Card(CardType.SPADE, CardValue.ACE), new Card(CardType.HEART, CardValue.TWO)));
        Money money = new Money(1000);
        Player player = new Player(name, playerCards, money);

        Cards dealerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.TEN), new Card(CardType.HEART, CardValue.TEN))));
        Dealer dealer = new Dealer(Name.generateDealerName(), dealerCards);
        dealer.pickCard(CardDeck.generateCardDeck());
        dealer.pickCard(CardDeck.generateCardDeck());
        PlayerScore playerScore = Judge.judgeScore(player, dealer);

        assertThat(playerScore.getProfit()).isEqualTo(1000);
    }

    @Test
    @DisplayName("플레이어 카드 합이 21을 초과할 경우 플레이어는 베팅 금액만큼의 손실을 입는다.")
    void PlayerLoseWhenSumOfPlayerCarsIsOver21() {
        Name name = Name.generatePlayerName("roy");
        Cards playerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.QUEEN), new Card(CardType.HEART, CardValue.KING))));
        Money money = new Money(1000);
        Player player = new Player(name, playerCards, money);
        player.pickCard(CardDeck.generateCardDeck());
        player.pickCard(CardDeck.generateCardDeck());

        Cards dealerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.TEN), new Card(CardType.HEART, CardValue.TEN))));
        Dealer dealer = new Dealer(Name.generateDealerName(), dealerCards);

        PlayerScore playerScore = Judge.judgeScore(player, dealer);

        assertThat(playerScore.getProfit()).isEqualTo(-1000);
    }

    @Test
    @DisplayName("플레이어 카드의 합이 딜러의 카드의 합보다 작을 경우 플레이어는 베팅금액 만큼 손실을 입는다.")
    void PlayerLoseWhenSumOfCarsIsLessThanDealerCards() {
        Name name = Name.generatePlayerName("roy");
        Cards playerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.TWO), new Card(CardType.HEART, CardValue.TWO))));
        Money money = new Money(1000);
        Player player = new Player(name, playerCards, money);

        Cards dealerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.THREE), new Card(CardType.HEART, CardValue.THREE))));
        Dealer dealer = new Dealer(Name.generateDealerName(), dealerCards);

        PlayerScore playerScore = Judge.judgeScore(player, dealer);

        assertThat(playerScore.getProfit()).isEqualTo(-1000);
    }

    @Test
    @DisplayName("플레이어 카드의 합이 딜러의 카드의 합보다 클 경우 플레이어는 베팅금액 만큼 이익을 입는다.")
    void PlayerWinWhenSumOfCarsIsMoreThanDealerCards() {
        Name name = Name.generatePlayerName("roy");
        Cards playerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.THREE), new Card(CardType.HEART, CardValue.THREE))));
        Money money = new Money(1000);
        Player player = new Player(name, playerCards, money);

        Cards dealerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.TWO), new Card(CardType.HEART, CardValue.TWO))));
        Dealer dealer = new Dealer(Name.generateDealerName(), dealerCards);

        PlayerScore playerScore = Judge.judgeScore(player, dealer);

        assertThat(playerScore.getProfit()).isEqualTo(1000);
    }

    @Test
    @DisplayName("플레이어 카드의 합이 딜러의 카드의 합과 같을 경우 플레이어는 이익은 0이다.")
    void GameIsTieWhenSumOfCarsIsSameWithDealerCards() {
        Name name = Name.generatePlayerName("roy");
        Cards playerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.THREE), new Card(CardType.HEART, CardValue.THREE))));
        Money money = new Money(1000);
        Player player = new Player(name, playerCards, money);

        Cards dealerCards = new Cards(new ArrayList<>(List.of(new Card(CardType.SPADE, CardValue.THREE), new Card(CardType.HEART, CardValue.THREE))));
        Dealer dealer = new Dealer(Name.generateDealerName(), dealerCards);

        PlayerScore playerScore = Judge.judgeScore(player, dealer);

        assertThat(playerScore.getProfit()).isEqualTo(0);
    }
}
