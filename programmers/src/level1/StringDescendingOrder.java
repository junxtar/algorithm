package level1;

import java.util.Arrays;

public class StringDescendingOrder {

	public String solution(String s) {
		char[] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Arrays.sort(ch);
		sb.append(String.copyValueOf(ch));
		return sb.reverse().toString();
	}
}
