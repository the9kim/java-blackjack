package domain.result;

import domain.user.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

	@DisplayName("Result 생성자 확인")
	@Test
	void create_Result() {
		assertThat(new Result(new HashMap<>())).isInstanceOf(Result.class);
	}

	@DisplayName("승리 플레이어 1, 무승부 플레이어 2, 패배 플레이어 3명일 경우 Result 반환 확인")
	@Test
	void createDealerResult_When_One_Win_Two_Draw_Three_Lose_From_Players() {
		Map<Player, ResultType> values = new HashMap<>();
		values.put(new Player("1"), ResultType.WIN);
		values.put(new Player("2"), ResultType.DRAW);
		values.put(new Player("3"), ResultType.DRAW);
		values.put(new Player("4"), ResultType.LOSE);
		values.put(new Player("5"), ResultType.LOSE);
		values.put(new Player("6"), ResultType.LOSE);

		Result result = new Result(values);

		Map<ResultType, Long> expected = new HashMap<>();
		expected.put(ResultType.LOSE, 1L);
		expected.put(ResultType.DRAW, 2L);
		expected.put(ResultType.WIN, 3L);

		Map<ResultType, Long> actual = result.createDealerResult();

		assertThat(actual).isEqualTo(expected);
	}
}