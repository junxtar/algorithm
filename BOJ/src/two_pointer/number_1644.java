package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class number_1644 {

	static int n;
	static int x;
	static int value = 0;
	static int answer = 0;
	static boolean[] isPrime;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		isPrime = new boolean[n + 1];
		for (int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		getPrime(n);
	}

	private static void getPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 0; i < isPrime.length; i++) {
			if (isPrime[i]) {
				list.add(i);
			}
		}
	}

	private static void solution() {
		int left = 0;
		int right = 0;
		while (true) {
			if (value == n) {
				answer++;
			}
			if (value >= n) {
				value -= list.get(left++);
			} else if (right == list.size()) {
				break;
			} else {
				value += list.get(right++);
			}
		}
		System.out.println(answer);
	}
}
