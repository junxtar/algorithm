package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class number_11000 {

	static class Time {
		int start;
		int end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		PriorityQueue<Integer>cq = new PriorityQueue<>();
		PriorityQueue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Time(start, end));
		}
		while (!pq.isEmpty()) {
			Time cur = pq.poll();
			if(cq.isEmpty()) {
				cq.offer(cur.end);
			}else {
				if(cur.start < cq.peek()) {
					cq.offer(cur.end);
				}else {
					cq.poll();
					cq.offer(cur.end);
				}
			}
		}
		System.out.println(cq.size());
	}

}
