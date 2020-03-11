package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.card.Card;
import domain.user.User;

public class OutputView {
	private static final String JOINING_DELIMITER = ", ";
	private static final String CARD_STRING_FORMAT = ": 카드: %s  ";
	private static final String RESULT_CARD_SCORE_FORMAT = "- 결과: %d";
	private static final String NEW_LINE = System.lineSeparator();

	private OutputView() {
	}

	public static void printInitialResult(List<User> users) {
		StringBuilder builder = new StringBuilder();
		for (User user : users) {
			builder.append(user.getName());
			builder.append(String.format(CARD_STRING_FORMAT, parseCardsString(user.getInitialCard())));
			builder.append(NEW_LINE);
		}
		System.out.println(builder);

	}

	public static void printUserResult(List<User> users) {
		StringBuilder builder = new StringBuilder();
		for (User user : users) {
			builder.append(user.getName());
			builder.append(String.format(CARD_STRING_FORMAT, parseCardsString(user.getInitialCard())));
			builder.append(String.format(RESULT_CARD_SCORE_FORMAT, user.calculateScore()));
			builder.append(NEW_LINE);
		}
		System.out.println(builder);
	}

	private static String parseCardsString(List<Card> cards) {
		return cards.stream()
			.map(OutputView::parseCardString)
			.collect(Collectors.joining(JOINING_DELIMITER));
	}

	private static String parseCardString(Card val) {
		return val.getSymbol() + val.getScore();
	}
}
