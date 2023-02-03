package Level2;

import java.util.Arrays;

public class SeesawPartner {
	// 시소 짝궁
	// 비율 정리를 배열에 반환
	static final int[][] rates = { { 1, 1 }, { 3, 2 }, { 4, 2 }, { 4, 3 } };

	public long solution(int[] weights) {
		long answer = 0;
		// 이분탐색을 위한 정렬
		Arrays.sort(weights);
		for (int[] rate : rates) {
			for (int i = 0; i < weights.length; i++) {
				int x = weights[i];
				// 만약 비례식을 통해서 나머지가 0이 아니면 다음 반복문으로 이동
				// ex) x: 100, rate[0]: 4, rate[1]:3 400은 3의 비율로 구할 수 없으므로 패스
				if (x * rate[0] % rate[1] != 0)
					continue;
				// 우리는 y값의 위치를 Weights배열에서 찾는다.
				int y = ((x * rate[0]) / rate[1]);

				// 상한식과 하한식을 이용해서 두개의 차이를 통해 중복 값을 도출해낼 수 있다.
				// idx) 0   1   2   3
				// ex) 100 100 100 180이 있다고 가정하면
				// 첫번째 인덱스로 도출해낼 수 있는 값은 {0,1 0,2} 로 총 2이다.

				// 위 경우 상한 값은 3이고 하한값은 1이므로 이 둘의 차이로 중복된 값을 찾아낼 수 있다
				int upper = upperBound(y, weights, i + 1, weights.length);

				int lower = lowerBound(y, weights, i + 1, upper);
				answer += (upper - lower);
			}
		}
		return answer;
	}

	static int upperBound(int findValue, int[] weights, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (findValue < weights[mid]) {
				right = mid;
				continue;
			}
			left = mid + 1;
		}
		return left;
	}

	static int lowerBound(int findValue, int[] weights, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			if (findValue <= weights[mid]) {
				right = mid;
				continue;
			}
			left = mid + 1;
		}
		return left;
	}
}