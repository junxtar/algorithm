package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class MiningMinerals {

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;
		int[][] mineralResult;
		int pickSum = 0;
		for (int i = 0; i < picks.length; i++) {
			pickSum += picks[i];
		}
		pickSum *= 5;
		if (pickSum > minerals.length) {
			mineralResult = minerals.length % 5 == 0 ? new int[minerals.length / 5][3]
					: new int[minerals.length / 5 + 1][3];
		} else {
			mineralResult = new int[pickSum / 5][3];
		}
		pickSum /= 5;
		for (int i = 0; i < mineralResult.length; i++) {
			for (int j = i * 5; j < (i + 1) * 5; j++) {
				if (j >= minerals.length)
					break;
				String mineral = minerals[j];
				if (mineral.equals("diamond")) {
					mineralResult[i][0]++;
				} else if (mineral.equals("iron")) {
					mineralResult[i][1]++;
				} else {
					mineralResult[i][2]++;
				}
			}
		}
		Arrays.sort(mineralResult, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1])
				.thenComparingInt(a -> a[2]).reversed());

		int index = 0;
		int pickIndex = 0;

		while (mineralResult.length > index && pickSum > 0) {
			if (picks[pickIndex] <= 0) {
				pickIndex++;
				continue;
			}
			if (pickIndex == 0) {
				for (int i = 0; i < 3; i++) {
					answer += mineralResult[index][i];
				}
			} else if (pickIndex == 1) {
				for (int i = 0; i < 3; i++) {
					if (i == 0) {
						answer += mineralResult[index][i] * 5;
					} else {
						answer += mineralResult[index][i];
					}
				}
			} else {
				for (int i = 0; i < 3; i++) {
					if (i == 0) {
						answer += mineralResult[index][i] * 25;
					} else if (i == 1) {
						answer += mineralResult[index][i] * 5;
					} else {
						answer += mineralResult[index][i];
					}
				}
			}
			index++;
			pickSum--;
			picks[pickIndex]--;

		}

		return answer;
	}
}