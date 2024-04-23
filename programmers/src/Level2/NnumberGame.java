package Level2;

import java.util.ArrayList;
import java.util.List;

public class NnumberGame {

	private List<Character> list = new ArrayList<>();
	private StringBuilder sb = new StringBuilder();

	public String solution(int n, int t, int m, int p) {
		int count = 0;
		int value = 0;
		if (m == p) {
			p = 0;
		}
		while (sb.length() < t) {
			String v = Integer.toString(value, n).toUpperCase();
			for (Character ch : v.toCharArray()) {
				count++;
				if (count % m == p) {
					sb.append(ch);
					if (sb.length() == t) {
						break;
					}
				}
			}
			value++;
		}
		return sb.toString();
	}
}
