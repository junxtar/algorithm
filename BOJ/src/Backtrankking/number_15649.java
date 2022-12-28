package Backtrankking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_15649 {
	static StringBuilder sb = new StringBuilder();
	static boolean[]temp;
	static int[]arr;
	public static void recur(int n, int m, int depth) {
		if(m == depth) {
			for(int data: arr) {
				sb.append(data+" ");
			}
			
			sb.append("\n");
			return;
		}
		for(int i = 0; i<n; i++) {
			if(!temp[i]) {
				temp[i] = true;
				arr[depth] = i+1;
				recur(n,m,depth+1);
				temp[i] = false;
			}
			
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		temp = new boolean[N];
		arr = new int[M];
		recur(N,M,0);
		System.out.println(sb);
		

	}

}
