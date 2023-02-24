package Level2;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ParkingFee {

	static class Record {
		int time;
		int cumulative;
		boolean exit;

		Record(int cumulative, int time, boolean exit) {
			this.cumulative = cumulative; // 누적 시간
			this.time = time; // 출차 or 입차 시간
			this.exit = exit; // 출차여부
		}
	}

	static final int LAST_TIME = 23 * 60 + 59;

	public int[] solution(int[] fees, String[] records) {
		ArrayList<Integer> result = new ArrayList<>();
		TreeMap<String, Record> map = new TreeMap<>();
		StringTokenizer st;
		for (int i = 0; i < records.length; i++) {
			st = new StringTokenizer(records[i], " : ");
			int time = Integer.parseInt(st.nextToken()) * 60;
			time += Integer.parseInt(st.nextToken());
			String carNum = st.nextToken();
			boolean exit = st.nextToken().equals("OUT") ? true : false;
			if (!map.containsKey(carNum)) {
				map.put(carNum, new Record(0, time, exit));
				continue;
			}

			if (exit) {
				map.get(carNum).cumulative += time - map.get(carNum).time;
			}
			map.get(carNum).time = time;
			map.get(carNum).exit = exit;
		}
		for (Record r : map.values()) {
			if (r.exit) {
				continue;
			}
			r.cumulative += (LAST_TIME - r.time);
		}

		for (String key : map.keySet()) {
			int value = map.get(key).cumulative;
			if (value <= fees[0]) {
				result.add(fees[1]);
				continue;
			}
			int div = (value - fees[0]) % fees[2];
			int v = div == 0 ? (value - fees[0]) / fees[2] : ((value - fees[0]) / fees[2] + 1);
			result.add(fees[1] + v * fees[3]);
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}