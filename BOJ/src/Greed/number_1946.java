package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x] = y;
			}
			int count = 1;
			int rank = 1;
			for (int i = 2; i <= N; i++) {
				if(arr[rank] > arr[i]) {
					rank = i;
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
