package Level2;

import java.util.Arrays;

public class H_Index {
	public int solution(int[] citations) {
		Arrays.sort(citations);
		int answer = 0;
		for (int i = citations.length - 1; i >= 0; i--) {
			int min = Math.min(citations.length - i, citations[i]);
			answer = answer < min ? min : answer;
		}
		return answer;
	}
}
