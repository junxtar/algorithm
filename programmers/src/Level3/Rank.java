package Level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rank {

	private List<List<Integer>> win = new ArrayList<>();
    private List<List<Integer>> lose = new ArrayList<>();
    private int[] dist;
    private boolean[] visited;
    
    public int solution(int n, int[][] results) {
        init(n, results);
        return setRank(n);
    }
    
    private void init(int n, int[][] results) {
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        for (int i = 0; i < results.length; i++) {
            int u = results[i][0];
            int v = results[i][1];
            win.get(u).add(v);
            lose.get(v).add(u);
        }
    }
    
    private int setRank(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dist[i] += bfs(i, n, win);
            dist[i] += bfs(i, n, lose);
            if (dist[i] == n - 1) {
                result++;
            }
        }
        return result;
    }
    
    private int bfs(int num, int n, List<List<Integer>> grapgh) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        visited[num] = true;
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (Integer value : grapgh.get(cur)) {
                if (!visited[value]) {
                    visited[value] = true;
                    q.offer(value);                    
                    cnt++;
                }
            }
        }
        return cnt;
    }
}