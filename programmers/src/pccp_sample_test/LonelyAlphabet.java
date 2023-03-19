package pccp_sample_test;

import java.util.HashSet;

public class LonelyAlphabet {

	public String solution(String input_string) {
		String answer = "";
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < input_string.length(); i++) {
			set.add(input_string.charAt(i));
		}
		for (Character c : set) {
			int cnt = 0;
			for (int i = 0; i < input_string.length(); i++) {
				if (input_string.charAt(i) == c) {
					cnt++;
					for (int j = i + 1; j < input_string.length(); j++) {
						if (input_string.charAt(j) != input_string.charAt(i)) {
							break;
						}
						i++;
					}
				}
			}
			if (cnt >= 2) {
				answer += c;
			}
		}
		return answer.equals("") ? "N" : answer;
	}
}