package level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ReceiveReportResults {

	public int[] solution(String[] id_list, String[] report, int k) {
		HashMap<String, Integer> result = new HashMap<>();
		HashMap<String, HashSet<String>> list = new HashMap<>();

		int[] answer = new int[id_list.length];

		StringTokenizer st;

		for (int i = 0; i < report.length; i++) {
			st = new StringTokenizer(report[i]);

			String reportUser = st.nextToken();
			String reportedUser = st.nextToken();

			if (!list.containsKey(reportUser))
				list.put(reportUser, new HashSet<>());
			list.get(reportUser).add(reportedUser);
		}

		for (String key : list.keySet()) {
			for (String data : list.get(key)) {
				result.put(data, result.getOrDefault(data, 0) + 1);
			}
		}
		for (int i = 0; i < id_list.length; i++) {
			if (list.containsKey(id_list[i])) {
				for (String data : list.get(id_list[i])) {
					if (result.get(data) >= k) {
						answer[i]++;
					}
				}
			}
		}
		return answer;
	}
}