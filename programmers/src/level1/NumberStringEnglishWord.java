package level1;

import java.util.HashMap;

public class NumberStringEnglishWord {

	static HashMap<String, String> alpha = new HashMap<>();

	public int solution(String s) {
		initMap();
		for (String key : alpha.keySet()) {
			s = s.replace(key, alpha.get(key));
		}
		return Integer.parseInt(s);
	}

	private void initMap() {
		alpha.put("zero", "0");
		alpha.put("one", "1");
		alpha.put("two", "2");
		alpha.put("three", "3");
		alpha.put("four", "4");
		alpha.put("five", "5");
		alpha.put("six", "6");
		alpha.put("seven", "7");
		alpha.put("eight", "8");
		alpha.put("nine", "9");
	}
}