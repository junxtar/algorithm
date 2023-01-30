package Level3;

import java.util.Arrays;

public class NumberGame {

	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int adex = 0;
		int bdex = 0;
		while (bdex < B.length && adex < A.length) {
			if (A[adex] >= B[bdex]) {
				bdex++;
				continue;
			}
			adex++;
			bdex++;
			answer++;
		}
		return answer;
	}
}
