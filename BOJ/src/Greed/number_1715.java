package Greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class number_1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer>pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while(!pq.isEmpty()) {
			if(pq.size() == 1) {
				break;
			}
			int a = pq.poll();
			int b = pq.poll();
			result += a+b;
			pq.offer(a+b);
			
		}
		System.out.println(result);
	}
}
