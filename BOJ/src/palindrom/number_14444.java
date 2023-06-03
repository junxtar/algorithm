package palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_14444 {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] input = br.readLine().toCharArray();
		String str = "";
		for (char ch : input) {
			sb.append("#").append(ch);
		}
		str = sb.append("#").toString();

		arr = new int[str.length()];
		
		manacher(str, arr.length);
		int max = 0;
		for (int value : arr) {
			max = Math.max(max, value);
		}
		System.out.println(max);

	}

	static void manacher(String str, int n) {
		int p = 0;
		int r = 0;

		for (int i = 0; i < n; i++) {
			if (i <= r) {
				arr[i] = Math.min(r - i, arr[2 * p - i]);
			} else {
				arr[i] = 0;
			}
			
			while (i - arr[i] - 1 >= 0 &&  i + arr[i] + 1 < n && str.charAt(i - arr[i] - 1) == str.charAt(i + arr[i] + 1)) {
				arr[i]++;
			}
			
			if (r < i + arr[i]) {
				r = i + arr[i];
				p = i;

			}
		}
	}
}
