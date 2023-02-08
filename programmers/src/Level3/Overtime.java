package Level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class Overtime {

	public long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < works.length; i++) {
			pq.offer(works[i]);
		}
		while (n-- > 0) {
			if (pq.isEmpty())
				return 0;
			if (pq.peek() - 1 != 0) {
				pq.add(pq.poll() - 1);
				continue;
			}
			pq.poll();
		}
		for (Integer data : pq) {
			answer += Math.pow(data, 2);
		}
		return answer;
	}
}