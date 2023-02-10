package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_1202 {
	static class Jewel {
		int weight;
		int price;

		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] arr = new Jewel[N];
		int[] bag = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			arr[i] = new Jewel(weight, price);
		}

		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if (o1.weight == o2.weight)
					return o2.price - o1.price;
				return o1.weight - o2.weight;
			}
		});
		Arrays.sort(bag);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long total = 0;
		for (int i = 0, j = 0; i < K; i++) {
			while (j < N && arr[j].weight <= bag[i]) {
				pq.offer(arr[j++].price);
			}
			if (!pq.isEmpty()) {
				total += pq.poll();
			}
		}
		System.out.println(total);
	}

}
