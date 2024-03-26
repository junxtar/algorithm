package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number_2531 {

	static int n, d, k, c;
	static int answer = 0;
	static int[] arr;
	static int[] eat;

	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[n];
		eat = new int[d + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	}

	private static void solution() {
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (eat[arr[i]]++ == 0) {
				cnt++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (answer <= cnt) {
				if (eat[c] == 0) {
					answer = cnt + 1;
				} else {
					answer = cnt;
				}
			}
			int j = (i + k) % n;
			if (--eat[arr[i]] == 0) {
				cnt--;
			}
			if (eat[arr[j]]++ == 0) {
				cnt++;
			}
		}
		System.out.println(answer);
	}
}
