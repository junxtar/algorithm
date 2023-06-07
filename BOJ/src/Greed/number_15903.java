package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_15903 {

	static PriorityQueue<Long> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		System.out.println(solution(M));
		
	}
	
	static long solution(int M) {
		while (M --> 0) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			
			pq.offer(num1 + num2);
			pq.offer(num1 + num2);
		}
		long sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		return sum;
	}
}
