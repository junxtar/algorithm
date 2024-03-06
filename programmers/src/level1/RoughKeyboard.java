package level1;

import java.util.HashMap;

public class RoughKeyboard {
	
	static HashMap<Character, Integer> map = new HashMap<>();

	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];

		for (int i = 0; i < targets.length; i++) {
			String target = targets[i];
			int result = 0;
			for (int j = 0; j < target.length(); j++) {
				char word = target.charAt(j);
				if (map.containsKey(word)) {
					if (map.get(word) == -1) {
						result = -1;
						break;
					}
					result += map.get(word);
					continue;
				}
				int value = searchKeyMap(keymap, word);
				map.put(word, value);
				if (value == -1) {
					result = -1;
					break;
				}
				result += value;
			}
			answer[i] = result;
		}
		return answer;
	}

	private int searchKeyMap(String[] keymap, char word) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < keymap.length; i++) {
			String key = keymap[i];
			int idx = key.indexOf(word);
			if (idx == -1) {
				continue;
			}
			min = Math.min(idx, min);
		}
		return min == Integer.MAX_VALUE ? -1 : min + 1;
	}
}
