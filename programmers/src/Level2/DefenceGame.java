package Level2;

import java.util.Collections;
import java.util.PriorityQueue;

// 문제의 핵심은 방어권을 쓰는 타이밍인 것이다. 
// 추가적인 반례 
//n = 10 k = 1 enemy = {10, 2, 2, 2, 2} answer = 5
//n = 10 k = 1 enemy = {2, 2, 2, 2, 10} answer = 5
//n = 10 k = 1 enemy = {2, 2, 10, 2, 2} answer = 5

public class DefenceGame {

	public int solution(int n, int k, int[] enemy) {
		// 우선순위 큐를 구현하여 최적의 타이밍에 방어권을 사용
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int answer = 0;
		for (int i = 0; i < enemy.length; i++) {
			// n의 값이 병사 수보다 적거나 방어권이 없을 경우 break;
			if (n < enemy[i] && k <= 0) {
				break;
			}
			// 막을 수단이 하나라도 존재한다면 우선순위 큐에 추가하고 병사의 공격에 대응
			pq.offer(enemy[i]);
			n -= enemy[i];
			answer++;
			// 만약에 n의 값이 0보다 작다면 방어권을 사용하여 그동안 막았던 공격중 가장 큰 수를 방어
			if (n < 0) {
				k--;
				n += pq.poll();
			}
		}
		return answer;
	}

}
