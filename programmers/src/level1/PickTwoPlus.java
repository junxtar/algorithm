package level1;

import java.util.TreeSet;

public class PickTwoPlus {

	static TreeSet<Integer> set = new TreeSet<>();
	static boolean[] visited;

	public TreeSet<Integer> solution(int[] numbers) {
		visited = new boolean[numbers.length];
		recur(0, 0, 0, numbers);
		return set;
	}

	static void recur(int depth, int sum, int index, int[] numbers) {
		if (depth == 2) {
			set.add(sum);
			return;
		}
		for (int i = index; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				recur(depth + 1, sum + numbers[i], index + 1, numbers);
				visited[i] = false;
			}
		}

	}
}
