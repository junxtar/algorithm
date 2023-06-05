package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class number_14226 {

	static class Imo {
		int screenCnt;
		int clipCnt;
		int sec;
		
		Imo(int screenCnt, int clipCnt, int sec) {
			this.screenCnt = screenCnt;
			this.clipCnt = clipCnt;
			this.sec = sec;
		}
	}
	
	static int S;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S  = Integer.parseInt(br.readLine());
		visited = new boolean[2001][2001];
		bfs();
		//0
	}
	static void bfs() {
		Queue<Imo> q = new LinkedList<>();
		q.offer(new Imo(1, 0, 0));
		visited[1][0] = true;
		
		while (!q.isEmpty()) {
			Imo cur = q.poll();
			
			if (cur.screenCnt == S) {
				System.out.println(cur.sec);
				return;
			}
			int nextCnt = cur.screenCnt + cur.clipCnt;
			int remove = cur.screenCnt - 1;
			if (nextCnt < 2000 && !visited[nextCnt][cur.clipCnt]) {
				visited[nextCnt][cur.clipCnt] = true;
				q.offer(new Imo(nextCnt, cur.clipCnt, cur.sec + 1));
			}
			if (nextCnt < 2000 && !visited[cur.screenCnt][nextCnt]) {
				visited[cur.screenCnt][nextCnt] = true;
				q.offer(new Imo(cur.screenCnt, cur.screenCnt, cur.sec + 1));
			}
			if (remove >= 0 && !visited[cur.screenCnt - 1][cur.clipCnt]) {
				visited[remove][cur.clipCnt] = true;
				q.offer(new Imo(remove, cur.clipCnt, cur.sec + 1));
			}
		}
	}
}
