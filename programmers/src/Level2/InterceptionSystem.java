package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class InterceptionSystem {

	public int solution(int[][] targets) {
		int answer = 0;
		Arrays.sort(targets, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		int flag = -1;
		for (int i = 0; i < targets.length; i++) {
			int targetX = targets[i][0];
			int targetY = targets[i][1];
			if (flag <= targetX) {
				answer++;
				flag = targetY;
			}
		}
		return answer;
	}

}
