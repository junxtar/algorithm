package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1182 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int S;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		if(S==0) {
			count--;
			System.out.print(count);
		}else {
			System.out.print(count);
		}
	}

	static void dfs(int depth, int result) {
		if (depth == N) {
			System.out.println(result);
			if(result == S) {
				count++;
			}
			return;
		}
		dfs(depth+1, result+arr[depth]);
		dfs(depth+1, result);
		
		}
}
