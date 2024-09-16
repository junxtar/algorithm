package level1;

import java.util.HashSet;

public class Park {
	private static int[][] dp;

	public int solution(int[] mats, String[][] park) {
		int answer = -1;
		dp = initDp(park);
		HashSet<Integer> s = new HashSet<>();
		for (int i = 1; i < park.length; i++) {
			for (int j = 1; j < park[0].length; j++) {
				if (dp[i][j] == 0) {
					continue;
				}

				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
				s.add(dp[i][j]);
			}
		}

		for (int su : mats) {
			if (s.contains(su)) {
				answer = Math.max(answer, su);
			}
		}

		return answer;
	}

	private int[][] initDp(String[][] park) {
		int[][] temp = new int[park.length][park[0].length];

		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[0].length; j++) {
				if (park[i][j].equals("-1")) {
					temp[i][j] = 1;
				}
			}
		}
		return temp;
	}
}
