package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class number_16953 {
	static class Node {
		long x;
		long y;

		Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		System.out.println(bfs(A, B));
	}

	static long bfs(long A, long B) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(A, 1));
		long res = -1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.x == B) {
				res = cur.y;
				break;
			}
			if(cur.x > B) {
				break;
			}
			long nx = cur.x * 2; 
			long jx = cur.x * 10 + 1; 
			
			if (nx <= B) {
				q.offer(new Node(nx, cur.y + 1)); 
			}
			if(jx <= B) { 
				q.offer(new Node(jx, cur.y + 1));
			}
		}
		return res;
	}

}
