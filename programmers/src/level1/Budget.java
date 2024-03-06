package level1;

import java.util.Arrays;

public class Budget {
	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		int count = 0;
		for (int value : d) {
			if (budget < value) {
				break;
			}
			budget -= value;
			count++;
		}
		return count;
	}
}
