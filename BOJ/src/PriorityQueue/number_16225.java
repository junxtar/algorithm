package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_16225 {

	static class Score {
		int a;
		int b;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Score> pq = new PriorityQueue<>((o1, o2) -> o1.b - o2.b);
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		
		Score[] arr = new Score[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Score();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i].a = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i].b = Integer.parseInt(st.nextToken());
			pq.offer(arr[i]);
		}
		
		long result = pq.poll().a;
		
		for (int i = 1; i < N - 1; i+=2) {
			pq2.offer(pq.poll().a);
			pq2.offer(pq.poll().a);
			result += pq2.poll();
		}
		System.out.println(result);
	}
}
