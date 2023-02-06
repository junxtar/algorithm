package Level2;

import java.util.Arrays;

public class Hopscotch {

	// 땅따먹기
	int solution(int[][] land) {
		// 새로운 이차원 배열 d를 선언한 후 1행은 land의 0행의 값으로 초기화
		int[][] d = new int[land.length][land[0].length];
		for (int i = 0; i < land[0].length; i++) {
			d[0][i] = land[0][i];
		}
		// 3중 반복문을 사용
		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					// 같은 열을 피해야 하므로 j == k가 같으면 continue;
					if (j == k)
						continue;
					// 열이 다른 것 중에서 최댓값 구하기
					d[i][j] = Math.max(d[i][j], land[i][j] + d[i - 1][k]);
				}
			}
		}
		// 마지막 행을 슬라이싱 해서 그 중 최대값 리턴
		return Arrays.stream(d[land.length - 1]).max().getAsInt();
	}
}