package Level3;

import java.util.Arrays;
import java.util.Comparator;

public class Level3_camera {

	public int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int answer = 1;
		int flag = routes[0][1];
		for (int i = 1; i < routes.length; i++) {
			if (routes[i][0] > flag) {
				flag = routes[i][1];
				answer++;
			}
		}
		return answer;
	}
}