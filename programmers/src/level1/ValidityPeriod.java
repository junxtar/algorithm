package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ValidityPeriod {

	static final int YEAR = 336;
	static final int MONTH = 28;

	public int[] solution(String today, String[] terms, String[] privacies) {
		ArrayList<Integer> answer = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(today, ".");
		int day = Integer.parseInt(st.nextToken()) * YEAR;
		day += Integer.parseInt(st.nextToken()) * MONTH;
		day += Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < terms.length; i++) {
			st = new StringTokenizer(terms[i]);
			map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < privacies.length; i++) {
			st = new StringTokenizer(privacies[i], ". ");
			int value = Integer.parseInt(st.nextToken()) * YEAR;
			value += Integer.parseInt(st.nextToken()) * MONTH;
			value += Integer.parseInt(st.nextToken());
			value += (map.get(st.nextToken()) * MONTH);
			if (value <= day) {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
