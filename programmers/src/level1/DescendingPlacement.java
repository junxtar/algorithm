package level1;

import java.util.Arrays;

public class DescendingPlacement {

	public long solution(long n) {
		StringBuilder sb = new StringBuilder();
		String[] arr = String.valueOf(n).split("");
		Arrays.sort(arr);

		for (String value : arr) {
			sb.append(value);
		}
		return Long.parseLong(sb.reverse().toString());
	}
}