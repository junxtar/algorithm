package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {

	static class Data {
		int index;
		double rate;

		Data(int index, double rate) {
			this.index = index;
			this.rate = rate;
		}
	}

	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		double userCount = stages.length;
		ArrayList<Data> list = new ArrayList<>();

		Arrays.sort(stages);
		init(list, N);
		int value = stages[0];
		int count = 1;
		for (int i = 1; i < stages.length; i++) {
			if (value == stages[i]) {
				count++;
				continue;
			}
			list.get(value - 1).rate = count / userCount;
			userCount -= count;
			count = 1;
			value = stages[i];
		}
		if (value <= N) {
			list.get(value - 1).rate = count / userCount;
		}
		Collections.sort(list, new Comparator<Data>() {
			public int compare(Data o1, Data o2) {
				if (o1.rate == o2.rate) {
					return o1.index - o2.index;
				}
				return Double.compare(o2.rate, o1.rate);
			}
		});
		int idx = 0;
		for (Data d : list) {
			answer[idx] = d.index + 1;
			idx++;
		}
		return answer;
	}

	static void init(ArrayList<Data> list, int N) {
		for (int i = 0; i < N; i++) {
			list.add(new Data(i, 0));
		}
	}
}
