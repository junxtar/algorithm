package level1;

import java.util.HashMap;

public class PersonalityTypeTest {

	static char[][] types = { { 'R', 'T' }, { 'C', 'F' }, { 'J', 'M' }, { 'A', 'N' } };
	static HashMap<Character, Integer> map = new HashMap<>();

	public String solution(String[] survey, int[] choices) {
		String answer = "";
		init();
		for (int i = 0; i < survey.length; i++) {
			int score = Math.abs(choices[i] - 4);
			if (choices[i] < 4)
				map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + score);

			if (choices[i] > 4)
				map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + score);
		}
		for (char[] type : types) {
			answer += (map.get(type[1]) <= map.get(type[0])) ? type[0] : type[1];
		}
		return answer;

	}

	static void init() {
		for (char[] type : types) {
			map.put(type[0], 0);
			map.put(type[1], 0);
		}
	}
}