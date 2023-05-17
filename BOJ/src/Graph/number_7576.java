package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class number_7576 {
    
    static class Node {
        int x;
        int y;
        int z;
        Node (int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int max = 0;
    static int count = 0;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();
    static int[] dxy = {1, 0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        count = N * M;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
                if (map[i][j] == 1 || map[i][j] == -1) {
                    count--;
                }
            }
        }
        bfs();
        if (count == 0) {
            System.out.println(max);
            return;
        } 
        System.out.println(-1);
    }
    static void bfs() {
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            max = Math.max(max, cur.z);
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dxy[i];
                int ny = cur.y + dxy[i + 1];
                
                if (nx < 0 | nx >= N | ny < 0 | ny >= M) continue;
                
                if (!visited[nx][ny] && map[nx][ny] != -1) {
                    count--;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.z + 1));
                }
            }
        }
    }
}