package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class number_24480{
	static StringBuilder sb = new StringBuilder();
static int N,M,V;
static ArrayList<ArrayList <Integer>>graph;
static int[]visit;
static int count = 1;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	V = Integer.parseInt(st.nextToken());
	visit = new int[N+1];
	graph = new ArrayList<ArrayList<Integer>>();
	for(int i = 0; i<=N; i++) {
		graph.add(new ArrayList<>());
	}
	while(M-->0) {
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		graph.get(u).add(v);
		graph.get(v).add(u);
	}
	for(int i = 1; i<=N; i++) {
		Collections.sort(graph.get(i),Collections.reverseOrder());
	}
	dfs(V);
	for(int i = 1; i<visit.length; i++) {
		sb.append(visit[i]).append("\n");
	}
	System.out.println(sb);

}
static void dfs(int V) {
	visit[V] = count++;
	
	for (int next : graph.get(V)) {
		if(visit[next]==0) {
			dfs(next);
			
		}
		
	}
	
	
}

}
