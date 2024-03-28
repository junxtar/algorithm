package Level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ZemShopping {

	HashMap<String, Integer> map = new HashMap<>();

	public int[] solution(String[] gems) {
		int size = new HashSet<>(Arrays.asList(gems)).size();

		int distance = Integer.MAX_VALUE;

		int left = 0;
		int right = 0;

		int answerL = 0;
		int answerR = 0;

		while (true) {
			if (size == map.size()) {
				map.put(gems[left], map.get(gems[left]) - 1);
				if (map.get(gems[left]) == 0) {
					map.remove(gems[left]);
				}
				left++;
			} else if (right == gems.length) {
				break;
			} else {
				map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
				right++;
			}
			if (map.size() == size) {
				if (right - left < distance) {
					distance = right - left;
					answerL = left + 1;
					answerR = right;
				}
			}
		}
		return new int[] { answerL, answerR };
	}
}
