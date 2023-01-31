package Level2;

import java.util.PriorityQueue;

public class MoreSpicy {

	// 더 맵게
	public int solution(int[] scoville, int K) {
		int answer = 0;
		// 우선순위 큐를 이용한 풀이
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			pq.offer(scoville[i]);
		}
		// 우선순위 큐에 가장 맵지 않은 스코빌 지수와 두 번째로 맵지 않은 스코빌 지수를
		// 가져와야하므로 사이즈 1보다 크면 반복
		while (pq.size() > 1) {
			// 만약에 가장 낮은 스코빌지수가 K보다 크면 조건 충족이므로 return
			if (pq.peek() >= K)
				return answer;
			// 아닐경우 answer++
			// 조건에 맞게 스코빌 섞기
			answer++;
			int n1 = pq.poll();
			int n2 = pq.poll() * 2;
			pq.offer(n1 + n2);
		}
		// 최종 합친 스코빌 지수가 K보다 크면 answer return
		if (pq.peek() > K)
			return answer;
		// 아닐경우 -1 return
		return -1;
	}
}