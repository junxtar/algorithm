package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class NumericTransformation {

	// 숫자 변환하기
	// vuale와 연산횟수를 담을 클래스 선언
	static class Node {
		int x;
		int cnt;

		Node(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	// 방문을 확인할 visited 진위형 배열 선언
	static boolean[] visited;

	public int solution(int x, int y, int n) {
		// 배열의 크기는 y+1로 생성
		visited = new boolean[y + 1];
		return dfs(x, y, n);
	}

	// dfs로 문제 풀이
	static int dfs(int x, int y, int n) {
		Queue<Node> q = new LinkedList<>();
		// x값 방문 처리
		visited[x] = true;
		// Queue에 x값과 연산 횟수 0을 추가
		q.offer(new Node(x, 0));
		// Queue에 아무것도 없을때까지 반복
		while (!q.isEmpty()) {
			Node cur = q.poll();
			// 만약 value값이 y랑 같다면 연산횟수 리턴
			if (cur.x == y) {
				return cur.cnt;
			}
			// 연산 방법 3가지 변수에 할당
			int nx1 = cur.x + n;
			int nx2 = cur.x * 2;
			int nx3 = cur.x * 3;
			// 연산 방법이 y값보다 작은지를 먼저 판단
			// 조건문에 visited[nx1] && nx1 <= y로 처리한다면 런타임에러가 날 수 있음
			// --> 솔루션 메서드 안에서 visited 배열 크기를
			// 이미 할당 했는데 그 범위가 벗어날 수 있기 때문에
			// 조건에 먼저 nx1 <= y 를 선언

			if (nx1 <= y && !visited[nx1]) {
				// nextvuale가 y보다 작고 방문하지 않았을 경우 Queue에 offer
				q.offer(new Node(nx1, cur.cnt + 1));
				// 방문처리
				visited[nx1] = true;
			}
			if (nx2 <= y && !visited[nx2]) {
				q.offer(new Node(nx2, cur.cnt + 1));
				visited[nx2] = true;
			}
			if (nx3 <= y && !visited[nx3]) {
				q.offer(new Node(nx3, cur.cnt + 1));
				visited[nx3] = true;
			}
		}
		// y값과 같은 vuale가 없다면 -1을 리턴
		return -1;
	}
}