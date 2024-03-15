package Level3;

import java.util.Arrays;

public class PerformanceReview {

	public int solution(int[][] scores) {
		int n = scores[0][0];
		int m = scores[0][1];
		int score = n + m;

		Arrays.sort(scores, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o2[0] - o1[0];
		});

		int flag = scores[0][1];
		for (int i = 0; i < scores.length; i++) {
			if (flag <= scores[i][1]) {
				flag = scores[i][1];
				continue;
			}
			if (n == scores[i][0] && m == scores[i][1]) {
				return -1;
			}
			scores[i][0] = -1;
			scores[i][1] = -1;
		}

		Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));

		int answer = 1;

		for (int i = 0; i < scores.length; i++) {
			if (scores[i][0] + scores[i][1] > score) {
				answer++;
				continue;
			}
			break;
		}
		return answer;
	}
}
