package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_15651 {
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	static int[]arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(1,0);
		System.out.println(sb);
	}
	static void dfs(int at, int depth) {
		if(M==depth) {
			for(int data: arr)
				sb.append(data+" ");
			sb.append("\n");
			return;
		}
		for(int i = at; i<=N; i++) {
			arr[depth] = i;
			dfs(at,depth+1);
		}
	}

}
