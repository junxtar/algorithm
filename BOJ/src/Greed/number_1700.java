package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class number_1700 {

	static int N, K;
	static int[] arr;
	static boolean[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int count = 0;
		int answer = 0;
		arr = new int[K];
		seq = new boolean[101];
		ArrayList<Integer> list;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < K; i++) {
			int target = arr[i];
			if (!seq[target]) {
				if (count < N) {
					seq[target] = true;
					count++;
				} else {
					list = new ArrayList<>();
					for (int j = i; j < K; j++) {
						if (seq[arr[j]] && !list.contains(arr[j])) {
							list.add(arr[j]);
						}
					}
					if (list.size() != N) {
						for (int j = 0; j < K + 1; j++) {
							if (seq[j] && !list.contains(j)) {
								seq[j] = false;
								break;
							}
						}
					} else {
						int remove = list.get(list.size() - 1);
						seq[remove] = false;
					}
					seq[target] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
