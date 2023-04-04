package Level2;

import java.util.Arrays;
import java.util.Collections;

public class PlayingAlone {

	static int cnt;
	static int[] values;
	static boolean[] visited;

	public int solution(int[] cards) {
		values = new int[cards.length];
		visited = new boolean[cards.length];

		for (int i = 0; i < cards.length; i++) {
			cnt = 0;
			recur(cards, i);
			values[i] = cnt;
		}

		values = Arrays.stream(values).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

		int result = values[0];
		if (result == cards.length) {
			return 0;
		}

		return result * values[result];
	}

	static void recur(int[] cards, int index) {
		if (!visited[index]) {
			visited[index] = true;
			recur(cards, cards[index] - 1);
			cnt++;
			visited[index] = false;
		}
	}
}
