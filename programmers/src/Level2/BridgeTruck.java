package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int values = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			int truck = truck_weights[i];
			while (true) {
				if (q.isEmpty()) {
					q.offer(truck);
					values += truck;
					answer++;
					break;
				}
				if (q.size() < bridge_length) {
					if (values + truck <= weight) {
						q.offer(truck);
						values += truck;
						answer++;
						break;
					} else {
						q.offer(0);
						answer++;
					}
				} else {
					values -= q.poll();
				}
			}
		}
		return answer + bridge_length;
	}
}
