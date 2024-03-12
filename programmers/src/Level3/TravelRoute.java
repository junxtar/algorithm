package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelRoute {

	private boolean[] visited;
	private List<String> routes = new ArrayList<>();

	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
		dfs(tickets, "ICN", "ICN", 0);
		return routes.get(0).split(" ");
	}

	private void dfs(String[][] tickets, String route, String destination, int depth) {
		if (depth == tickets.length) {
			routes.add(route);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && tickets[i][0].equals(destination)) {
				visited[i] = true;
				dfs(tickets, route + " " + tickets[i][1], tickets[i][1], depth + 1);
				visited[i] = false;
			}
		}
	}
}
