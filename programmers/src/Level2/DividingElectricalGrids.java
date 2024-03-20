package Level2;

import java.util.ArrayList;

public class DividingElectricalGrids {

	ArrayList<ArrayList<Integer>> map = new ArrayList<>();

	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}
		for (int i = 0; i < wires.length; i++) {
			int u = wires[i][0];
			int v = wires[i][1];
			map.get(u).add(v);
			map.get(v).add(u);
		}

		for (int i = 0; i < wires.length; i++) {
			int u = wires[i][0];
			int v = wires[i][1];
			map.get(u).remove(Integer.valueOf(v));
			map.get(v).remove(Integer.valueOf(u));
			boolean[] visited = new boolean[n + 1];
			int cnt = dfs(1, visited);
			answer = Math.min(Math.abs(cnt - (n - cnt)), answer);

			map.get(u).add(v);
			map.get(v).add(u);
		}
		return answer;
	}

	private int dfs(int v, boolean[] visited) {
		visited[v] = true;
		int cnt = 1;

		for (int next : map.get(v)) {
			if (!visited[next]) {
				visited[next] = true;
				cnt += dfs(next, visited);
			}
		}
		return cnt;
	}
}
