package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {

	static Queue<String> q = new LinkedList<>();

	public int solution(int cacheSize, String[] cities) {
		cities = init(cities);

		return cacheCheck(cities, cacheSize);
	}

	static String[] init(String[] cities) {
		String[] temp = cities.clone();
		for (int i = 0; i < cities.length; i++) {
			temp[i] = cities[i].toLowerCase();
		}
		return temp;
	}

	static int cacheCheck(String[] cities, int cacheSize) {
		int answer = 0;
		for (String city : cities) {
			if (q.contains(city)) {
				q.remove(city);
				q.offer(city);
				answer += 1;
				continue;
			}
			answer += 5;
			if (q.size() < cacheSize) {
				q.offer(city);
				continue;
			}
			q.offer(city);
			q.poll();
		}
		return answer;
	}
}
