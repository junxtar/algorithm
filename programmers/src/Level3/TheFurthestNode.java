package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheFurthestNode {

	static class Node {
		int x;
		int z;

		Node(int x, int z) {
			this.x = x;
			this.z = z;
		}
	}

	static int[] visited;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public int solution(int n, int[][] edge) {
		
		int answer = 0;
		visited = new int[n + 1];
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < edge.length; i++) {
			list.get(edge[i][0]).add(edge[i][1]);
			list.get(edge[i][1]).add(edge[i][0]);
		}
		
		bfs(1);
		
		int max = Arrays.stream(visited).max().getAsInt();
		
		for (int i = 2; i < visited.length; i++) {
			if (max == visited[i])
				answer++;
		}
		return answer;
	}

	static void bfs(int x) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, 0));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < list.get(cur.x).size(); i++) {
				int value = list.get(cur.x).get(i);
				if (visited[value] == 0) {
					q.offer(new Node(value, cur.z + 1));
					visited[value] = cur.z + 1;
				}
			}
		}
	}
}