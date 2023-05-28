package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_9470 {
	
	static class Node {
		int v;
		int str;
		
		Node (int v, int str) {
			this.v = v;
			this.str = str;
		}
	}
	static int K, N, M;
	static int[] seq;
	static int[] strahler;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> grapgh;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			seq = new int[N + 1];
			strahler = new int[N + 1];
			visited = new boolean[N + 1];
			grapgh = new ArrayList<>();
			for (int i = 0; i < N + 1; i++) {
				grapgh.add(new ArrayList<>());
			}
			while (M --> 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				seq[v]++;
				grapgh.get(u).add(new Node(v, 0));
			}
			topologicalSort();
		}
		System.out.println(sb.toString());
	}
	
	static void topologicalSort() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 1; i < seq.length; i++) {
			if(seq[i] == 0) {
				q.offer(new Node(i, 1));
				strahler[i] = 1;
			}
		}
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			
			for (Node next : grapgh.get(cur.v)) {
				if(strahler[next.v] < cur.str) {
					strahler[next.v] = cur.str;
					visited[next.v] = false;
				} else if (strahler[next.v] == cur.str){
					visited[next.v] = true;
				}
				seq[next.v]--;
				if(seq[next.v] == 0) {
					if(visited[next.v]) {
						strahler[next.v]++;
					}
					q.offer(new Node(next.v, strahler[next.v]));
				}
			}
		}
		int max = 0;
		for (int i = 1; i < strahler.length; i++) {
			max = Math.max(max, strahler[i]);
		}
		sb.append(K).append(" ").append(max).append("\n");
	}
}
