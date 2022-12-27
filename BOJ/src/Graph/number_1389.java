package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_1389 {
	static class Number{
		int index;
		int number;
		Number(int index, int number){
			this.index = index;
			this.number = number;
		}
	}
	static int N;
	static boolean[] visited;
	static int[][] grapgh;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		grapgh = new int[N+1][N+1];
		ArrayList<Number>list = new ArrayList<>();
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			grapgh[u][v] = 1;
			grapgh[v][u] = 1;
		}
		for(int i = 1; i<=N; i++) {
			list.add(new Number(i, bfs(i)));
		}
		Collections.sort(list, new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				if(o1.number == o2.number) {
					return o1.index - o2.index;
				}
				return o1.number - o2.number;
			}
			
		});
		System.out.println(list.get(0).index);
	}
	static int bfs(int start) {
		int result = 0;
		visited = new boolean[N+1];
		visited[start] = true;
		Queue<Number>q = new LinkedList<>();
		q.offer(new Number(start, 0));
		while(!q.isEmpty()) {
			Number cur = q.poll();
			for(int i = 1; i<=N; i++) {
				if(grapgh[cur.index][i] == 1 && !visited[i]) {
					visited[i] = true;
					result+=cur.number+1;
					q.offer(new Number(i,cur.number+1));
				}
			}
		}
		return result;
	}

}
