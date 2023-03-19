package pccp_sample_test;

public class AthleticCompetition {
	
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited;

	public int solution(int[][] ability) {
		int N = ability[0].length;
		visited = new boolean[ability.length];
		arr = new int[N];
		backtracking(0, N, ability);
		return max;
	}

	static void backtracking(int depth, int N, int[][] ability) {
		if (depth == N) {
			int sum = 0;
			for (int value : arr) {
				sum += value;
			}
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < ability.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = ability[i][depth];
				backtracking(depth + 1, N, ability);
				visited[i] = false;
			}
		}
	}
}