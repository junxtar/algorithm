package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class NewsClustering {

	static HashSet<String> set;

	public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		set = new HashSet<>();
		int union = 0, answer = 0;

		input(map1, str1);
		input(map2, str2);

		for (String s : set) {
			union += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
		}
		for (String s : map2.keySet()) {
			if (map1.containsKey(s)) {
				answer += Math.min(map1.get(s), map2.get(s));
			}
		}
		if (union == 0)
			return 65536;

		return answer * 65536 / union;
	}

	static boolean isAlphabet(char ch) {
		if (ch < 'a' || ch > 'z')
			return false;
		return true;
	}

	static void input(HashMap<String, Integer> map, String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			String value = str.substring(i, i + 2);
			if (isAlphabet(value.charAt(0)) && isAlphabet(value.charAt(1))) {
				map.put(value, map.getOrDefault(value, 0) + 1);
				set.add(value);
			}
		}
	}
}