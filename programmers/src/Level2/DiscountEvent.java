package Level2;

import java.util.HashMap;

public class DiscountEvent {
	
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
		}
		if (isContains(map, want, number))
			answer++;

		for (int i = 10; i < discount.length; i++) {
			map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
			map.put(discount[i - 10], map.get(discount[i - 10]) - 1);
			if (isContains(map, want, number))
				answer++;
		}
		return answer;
	}

	static boolean isContains(HashMap<String, Integer> map, String[] want, int[] number) {
		for (int i = 0; i < want.length; i++) {
			if (!map.containsKey(want[i]) || number[i] > map.get(want[i]))
				return false;
		}
		return true;
	}
}