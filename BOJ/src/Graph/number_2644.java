package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_2644 {
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x =x;
			this.y =y;
		}
	}
	static int N;
	static ArrayList<ArrayList<Integer>> grapgh;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		grapgh = new ArrayList<>();
		visited = new boolean[N+1];
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(v);
			grapgh.get(v).add(u);
		}
		System.out.println(bfs(start, end));
		
	}
	static int bfs(int start, int end) {
		Queue<Node>q = new LinkedList<>();
		q.offer(new Node(start, 0));
		visited[start] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x == end) {
				return cur.y;
			}
			for(int i = 0; i<grapgh.get(cur.x).size(); i++) {
				int next = grapgh.get(cur.x).get(i);
				if(!visited[next]) {
					q.offer(new Node(next,cur.y+1));
					visited[next] = true;
				}
			}
		}
		return -1;
	}

}
