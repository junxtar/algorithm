package Level2;

public class Fatigue {

	static boolean[] visited;

	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		return backtracking(dungeons, k);
	}

	static int backtracking(int[][] dungeons, int k) {
		int max = 0;
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && dungeons[i][0] <= k) {
				visited[i] = true;
				max = Math.max(max, backtracking(dungeons, k - dungeons[i][1]));
				visited[i] = false;
			}
		}
		return Math.max(max, visit(visited));
	}

	static int visit(boolean[] visited) {
		int count = 0;
		for (boolean v : visited) {
			if (v)
				count++;
		}
		return count;
	}
}