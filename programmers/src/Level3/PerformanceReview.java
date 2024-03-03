package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PerformanceReview {

	static class Person {
		int index;
		int sum;

		Person(int index, int sum) {
			this.index = index;
			this.sum = sum;
		}
	}

	static List<Person> list = new ArrayList<>();

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
			int sum = scores[i][0] + scores[i][1];
			if (flag <= scores[i][1]) {
				flag = scores[i][1];
				list.add(new Person(i, sum));
				continue;
			}
			if (n == scores[i][0] && m == scores[i][1]) {
				return -1;
			}
		}

		Collections.sort(list, (o1, o2) -> o2.sum - o1.sum);

		int left = 0;
		int right = list.size();

		while (left < right) {
			int mid = (left + right) / 2;
			if (list.get(mid).sum <= score) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left + 1;
	}
}