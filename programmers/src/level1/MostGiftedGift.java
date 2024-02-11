package level1;

import java.util.HashMap;
import java.util.StringTokenizer;

public class MostGiftedGift {

	static HashMap<String, Integer> giftMap = new HashMap<>();
	static HashMap<String, HashMap<String, Integer>> table = new HashMap<>();

	public int solution(String[] friends, String[] gifts) {
		initMap(friends);
		giftPoint(gifts);
		int answer = 0;
		for (String name : table.keySet()) {
			int count = 0;
			for (String friend : friends) {
				if (name.equals(friend)) {
					continue;
				}
				int myPoint = table.get(name).get(friend);
				int friendPoint = table.get(friend).get(name);
				if (myPoint > friendPoint) {
					count++;
					continue;
				}
				if (myPoint == friendPoint) {
					if (giftMap.get(name) > giftMap.get(friend)) {
						count++;
					}
				}
			}
			answer = Math.max(count, answer);
		}
		return answer;
	}

	static void initMap(String[] friends) {
		for (String friend : friends) {
			table.put(friend, new HashMap<>());
			giftMap.put(friend, 0);
		}
		for (String key : table.keySet()) {
			for (String friend : friends) {
				if (key.equals(friend)) {
					continue;
				}
				table.get(key).put(friend, 0);
			}
		}
	}

	static void giftPoint(String[] gifts) {
		StringTokenizer st;
		for (String gift : gifts) {
			st = new StringTokenizer(gift);
			String pub = st.nextToken();
			String sub = st.nextToken();

			table.get(pub).put(sub, table.get(pub).getOrDefault(sub, 0) + 1);
			giftMap.put(pub, giftMap.get(pub) + 1);
			giftMap.put(sub, giftMap.get(sub) - 1);
		}
	}
}