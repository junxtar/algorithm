package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class number_14676 {
	static int N, M, K;

	static ArrayList<ArrayList<Integer>> grapgh;
	static ArrayList<ArrayList<Integer>> remove;
	static int[] seq;
	static int[] build;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		seq = new int[N + 1];
		build = new int[N + 1];
		remove = new ArrayList<>(); 
		grapgh = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			grapgh.add(new ArrayList<>());
			remove.add(new ArrayList<>());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			grapgh.get(u).add(v);
			seq[v]++;
		}
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (command == 1 && seq[num] != 0 || command == 2 && build[num] == 0) {
				System.out.println("Lier!");
				System.exit(0);
			}
			if (command == 1) {
				build[num]++;
				for (int next : grapgh.get(num)) {
					if (!remove.get(next).contains(num)) {
						remove.get(next).add(num);
					}
					if (seq[next] == 0)
						continue;
					seq[next]--;
				}
			} else {
				build[num]--;
				if (build[num] == 0) {
					for (int next : grapgh.get(num)) {
						remove.get(next).clear();
						seq[next]++;
					}
				}
			}
		}
		System.out.println("King-God-Emperor");
	}
}
