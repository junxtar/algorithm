package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_10974 {

	static int[]arr;
	static int N,M;
	static boolean[]visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = N;
		arr = new int[N];
		visit = new boolean[N];
		dfs(N,M,0);
		System.out.println(sb);
	}
	static void dfs(int n, int m, int depth) {
		if(depth == m) {
			for(int data:arr) {
				sb.append(data+" ");
			}sb.append("\n");
			return;
		}
		for(int i = 0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(n,m,depth+1);
				visit[i] = false;
			}
		}
	}
}
