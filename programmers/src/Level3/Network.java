package Level3;

//네트워크 
public class Network {
	// 방문 노드를 체크할 boolean 배열 선언
	static boolean[] visited;

	public int solution(int n, int[][] computers) {

		int answer = 0;
		visited = new boolean[n];

		// 2차원 배열을 처음부터 돌면서 1이면 dfs돌려주고 결과값+1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1 && !visited[i]) {
					dfs(i, computers);
					answer++;
				}
			}
		}
		return answer;
	}

	static void dfs(int v, int[][] computers) {
		//방문했으므로 true 선언 
		visited[v] = true;
		//다시 해당 열 돌아주면서 다시 찾은후 연결되어있는 노선이 있다면 dfs() 돌려주기 
		for (int i = 0; i < computers.length; i++) {
			if (computers[v][i] == 1 && !visited[i]) {
				dfs(i, computers);
			}
		}
	}
}
