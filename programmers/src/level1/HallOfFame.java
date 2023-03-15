package level1;

import java.util.PriorityQueue;

public class HallOfFame {

	public int[] solution(int k, int[] score) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] answer = new int[score.length];
		for (int i = 0; i < score.length; i++) {
			if (pq.size() < k) {
				pq.offer(score[i]);
			} else if (pq.size() >= k && pq.peek() < score[i]) {
				pq.poll();
				pq.offer(score[i]);
			}

			answer[i] = pq.peek();
		}
		return answer;
	}
}