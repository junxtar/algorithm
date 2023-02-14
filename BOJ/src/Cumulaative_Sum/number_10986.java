package Cumulaative_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_10986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long result = 0;
		long[] arr = new long[n + 1];
		long[] count = new long[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = (Integer.parseInt(st.nextToken()) + arr[i - 1]) % m;
			if (arr[i] % m == 0) {
				result++;
			}
			count[(int) arr[i]]++;
		}
		for (int i = 0; i < m; i++) {
			if (count[i] > 1) {
				result += (count[i] * (count[i] - 1) / 2);
			}
		}
		System.out.println(result);
	}
}
