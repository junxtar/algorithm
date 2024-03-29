package Level3;

import java.util.Arrays;

public class Immigration {

	public long solution(int n, int[] times) {
		int length = times.length;
		Arrays.sort(times);

		long minTime = 1;
		long maxTime = (long) times[length - 1] * n;
		long answer = maxTime;

		while (minTime <= maxTime) {
			long avgTime = (minTime + maxTime) / 2;
			System.out.println(avgTime);
			long temp = 0;

			for (int i = 0; i < length; i++) {
				temp += avgTime / times[i];
				if (temp >= n) {
					break;
				}
			}

			if (temp < n) {
				minTime = avgTime + 1;
			} else {
				answer = Math.min(answer, avgTime);
				maxTime = avgTime - 1;
			}
		}

		return answer;
	}
}
